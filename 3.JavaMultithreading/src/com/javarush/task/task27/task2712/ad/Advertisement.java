package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

public class Advertisement implements Comparable<Advertisement> {

    private Object content;
    private String name;
    private long initialAmount; //начальная сумма, стоимость рекламы в копейках
    private int hits; //количество оплаченных показов
    private int duration; //продолжительность в секундах

    private long amountPerOneDisplaying; //стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits < 1) {
            throw new NoVideoAvailableException();
        }
        hits--;
    }

    @Override
    public int compareTo(Advertisement o) {
        return (int) (o.amountPerOneDisplaying - this.amountPerOneDisplaying);
    }

    @Override
    public String toString() {
        return String.format("%s is displaying... %d, %d",
                name,
                amountPerOneDisplaying,
                amountPerOneDisplaying * 1000 / duration);
    }
}
