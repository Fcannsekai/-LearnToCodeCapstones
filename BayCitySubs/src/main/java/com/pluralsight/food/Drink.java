package com.pluralsight.food;

public class Drink {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small" -> {
                return 2.00;
            }
            case "medium" -> {
                return 2.50;
            }
            case "large" -> {
                return 3.00;
            }
            default -> {
                return 0.00;
            }
        }
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return size + " " + flavor + " ($" + price + ")";
    }
}

//This is just a basic class for drink with switch case and pricing