package com.pluralsight.food;

public class Chip {
    private String type;
    private double price;

    public Chip(String type) {
        this.type = type;
        this.price = 3.00; // Im going to make the chips a flat rate price it feels unnecessary to use sizing
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return type + " chips ($" + price + ")";
    }
}


// this is just a basic class for chips with pricing.