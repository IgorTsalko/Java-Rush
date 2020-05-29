package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private final int timeSeconds;
    private List<Advertisement> bestAdList = new ArrayList<>();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.getHits() > 0) {
                advertisements.add(ad);
            }
        }

        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        recursionSearchBestAdList(advertisements);

        Collections.sort(bestAdList);

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestAdList,
                calcTotalCost(bestAdList),
                calcTotalTime(bestAdList)));

        showBestAdList();
    }

    private void showBestAdList() {
        for (Advertisement ad : bestAdList) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate();
        }
    }

    private void recursionSearchBestAdList(List<Advertisement> adList) {
        if (!adList.isEmpty()) {
            checkAdList(adList);
        }

        for (int i = 0; i < adList.size(); i++) {
            List<Advertisement> checkedList = new ArrayList<>(adList);
            checkedList.remove(i);

            recursionSearchBestAdList(checkedList);
        }
    }

    private void checkAdList(List<Advertisement> checkedList) {
        if (calcTotalTime(checkedList) <= timeSeconds) {

            if (bestAdList.isEmpty()) {
                bestAdList = checkedList;
            }


            if (calcTotalCost(checkedList) > calcTotalCost(bestAdList)) {
                bestAdList = checkedList;
            } else if (calcTotalCost(checkedList) == calcTotalCost(bestAdList)) {
                if (calcTotalTime(checkedList) > calcTotalTime(bestAdList)) {
                    bestAdList = checkedList;
                } else if (calcTotalTime(checkedList) == calcTotalTime(bestAdList)) {
                    if (checkedList.size() < bestAdList.size()) {
                        bestAdList = checkedList;
                    }
                }
            }
        }
    }

    private long calcTotalCost(List<Advertisement> adList) {
        long totalCost = 0;

        for (Advertisement ad : adList) {
            totalCost += ad.getAmountPerOneDisplaying();
        }

        return totalCost;
    }

    private int calcTotalTime(List<Advertisement> adList) {
        int totalTime = 0;

        for (Advertisement ad : adList) {
            totalTime += ad.getDuration();
        }

        return totalTime;
    }
}
