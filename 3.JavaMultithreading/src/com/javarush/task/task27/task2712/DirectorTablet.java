package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.List;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        double total = 0;

        for (Map.Entry<String, Long> profitByDates : StatisticManager.getInstance().getProfit().entrySet()) {
            String date = profitByDates.getKey();
            double cost = profitByDates.getValue()/100.0;

            if (cost > 0) {
                ConsoleHelper.writeMessage(String.format("%s - %.2f", date, cost));
                total += cost;
            }
        }

        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }

    public void printCookWorkloading() {
        for (Map.Entry<String, Map<String, Integer>> data : StatisticManager.getInstance().getWorkloadData().entrySet()) {
            ConsoleHelper.writeMessage(data.getKey());

            for (Map.Entry<String, Integer> cookData : data.getValue().entrySet()) {
                String cookName = cookData.getKey();
                int totalTime = (int) Math.ceil(cookData.getValue() / 60.0);

                if (totalTime > 0) {
                    ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, totalTime));
                }
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        for (Map.Entry<String, Integer> ad : StatisticAdvertisementManager.getInstance().getAllActiveVideos().entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getKey(), ad.getValue()));
        }
    }

    public void printArchivedVideoSet() {
        List<String> archivedVideoSet = StatisticAdvertisementManager.getInstance().getAllArchivedVideos();
        archivedVideoSet.sort(String::compareToIgnoreCase);
        for (String adName : archivedVideoSet) {
            ConsoleHelper.writeMessage(adName);
        }
    }
}
