package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {

    private static final StatisticAdvertisementManager INSTANCE = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {}

    public static StatisticAdvertisementManager getInstance() {
        return INSTANCE;
    }

    public Map<String, Integer> getAllActiveVideos() {
        Map<String, Integer> activeVideos = new TreeMap<>();

        for (Advertisement ad : storage.list()) {
            if (ad.getHits() > 0) {
                activeVideos.put(ad.getName(), ad.getHits());
            }
        }

        return activeVideos;
    }

    public List<String> getAllArchivedVideos() {
        List<String> archivedVideos = new ArrayList<>();

        for (Advertisement ad : storage.list()) {
            if (ad.getHits() == 0) {
                archivedVideos.add(ad.getName());
            }
        }

        return archivedVideos;
    }

}
