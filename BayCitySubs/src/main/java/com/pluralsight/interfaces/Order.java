package com.pluralsight.interfaces;

import com.pluralsight.food.Sandwich;
import com.pluralsight.food.Drink;
import com.pluralsight.food.Chip;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Drink>   drinks     = new ArrayList<>();
    private final List<Chip>    chips      = new ArrayList<>();

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
    }

    public void addDrink(Drink d) {
        drinks.add(d);
    }

    public void addChips(Chip c) {
        chips.add(c);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d    : drinks)     total += d.getPrice();
        for (Chip c     : chips)      total += c.getPrice();
        return total;
    }
}

//This class should hold current orders