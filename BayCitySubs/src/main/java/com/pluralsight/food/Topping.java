package com.pluralsight.food;

public class Topping {
    private String name;
    private String type;
    private boolean isExtra;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type.toLowerCase();
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public boolean isPremium() {
        return type.equals("meat") || type.equals("cheese");
    }

    public double getPrice(String size, boolean isExtra) {
        double price = 0.0;

        if (type.equals("meat")) {
            price = switch (size) {
                case "4" -> isExtra ? 0.50 : 1.00;
                case "8" -> isExtra ? 1.00 : 2.00;
                case "12" -> isExtra ? 1.50 : 3.00;
                default -> 0.0;
            };
        } else if (type.equals("cheese")) {
            price = switch (size) {
                case "4" -> isExtra ? 0.30 : 0.75;
                case "8" -> isExtra ? 0.60 : 1.50;
                case "12" -> isExtra ? 0.90 : 2.25;
                default -> 0.0;
            };
        }

        return price;
    }

    public String getType() {
        return type;
    }
}

/*This class is a functional topping class that should be able to interact with my sandwich class as well as the
topping selection class which then will connect to a CLI in which a customer can choose what they want.*/