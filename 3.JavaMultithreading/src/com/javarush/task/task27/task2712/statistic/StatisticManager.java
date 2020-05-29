package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {

    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticManager instance;

    private StatisticManager() {}

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getProfit() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Map<String, Long> profitMap = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) event;
            String date = dateFormat.format(videoEvent.getDate());

            if (profitMap.containsKey(date)) {
                profitMap.put(date, profitMap.get(date) + videoEvent.getAmount());
            } else {
                profitMap.put(date, videoEvent.getAmount());
            }
        }

        return profitMap;
    }

    public Map<String, Map<String, Integer>> getWorkloadData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Map<String, Map<String, Integer>> workloadData = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow e : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
            String date = dateFormat.format(e.getDate());

            if (workloadData.containsKey(date)) {
                continue;
            }

            Map<String, Integer> cookWorkload = new TreeMap<>();

            for (EventDataRow event : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
                CookedOrderEventDataRow cookedEvent = (CookedOrderEventDataRow) event;
                String name = cookedEvent.getCookName();

                if (cookWorkload.get(name) != null) {
                    cookWorkload.put(name, cookWorkload.get(name) + event.getTime());
                } else {
                    cookWorkload.put(name, event.getTime());
                }
            }

            workloadData.put(date, cookWorkload);
        }

        return workloadData;
    }

    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
