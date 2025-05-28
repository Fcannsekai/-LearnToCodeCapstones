package com.pluralsight.food;

import com.pluralsight.interfaces.CustomizeFood;
import com.pluralsight.interfaces.Pricable;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Pricable, CustomizeFood {

    private String size; // "4", "8", or "12"
    private String breadType; // white, rosemary garlic, sourdough, garlic knot
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    @Override
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    @Override
    public double getPrice() {
        double price = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0.0;
        };

        for (Topping topping : toppings) {
            if (topping.isPremium()) {
                price += topping.getPrice(size, topping.isExtra());
            }
        }

        return price;
    }

    @Override
    public String toString() {
        String result = size + "\" " + breadType + " sandwich\n";
        if (toasted) {
            result += "Toasted\n";
        }

        result += "Toppings:\n";
        for (Topping t : toppings) {
            result += "  - " + t.getName();
            if (t.isExtra()) {
                result += " (extra)";
            }
            result += "\n";
        }

        result += String.format("Total: $%.2f", getPrice());
        return result;
    }
}