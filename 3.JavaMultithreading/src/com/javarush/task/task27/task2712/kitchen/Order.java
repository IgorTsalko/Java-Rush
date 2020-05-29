package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "";
        return "Your order: " + dishes + " of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int totalCookingTime = 0;

        for (Dish dish : dishes) {
            totalCookingTime += dish.getDuration();
        }

        return totalCookingTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
