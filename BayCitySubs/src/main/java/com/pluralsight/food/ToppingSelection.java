package com.pluralsight.food;

import java.util.ArrayList;
import java.util.List;

public class ToppingSelection {

    public static List<Topping> getMeatOptions(boolean includeExtras) {
        List<Topping> meats = new ArrayList<>();
        meats.add(new Topping("steak", "meat", false));
        meats.add(new Topping("ham", "meat", false));
        meats.add(new Topping("salami", "meat", false));
        meats.add(new Topping("roast beef", "meat", false));
        meats.add(new Topping("chicken", "meat", false));
        meats.add(new Topping("bacon", "meat", false));
        meats.add(new Topping("turkey", "meat", false));

        if (includeExtras) {
            for (int i = 0; i < meats.size(); i++) {
                Topping original = meats.get(i);
                meats.add(new Topping(original.getName(), "meat", true));
            }
        }

        return meats;
    }

    public static List<Topping> getCheeseOptions(boolean includeExtras) {
        List<Topping> cheeses = new ArrayList<>();
        cheeses.add(new Topping("american", "cheese", false));
        cheeses.add(new Topping("provolone", "cheese", false));
        cheeses.add(new Topping("cheddar", "cheese", false));
        cheeses.add(new Topping("swiss", "cheese", false));
        cheeses.add(new Topping("jack", "cheese", false));

        if (includeExtras) {
            for (int i = 0; i < cheeses.size(); i++) {
                Topping original = cheeses.get(i);
                cheeses.add(new Topping(original.getName(), "cheese", true));
            }
        }

        return cheeses;
    }

    public static List<Topping> getRegularOptions() {
        List<Topping> regulars = new ArrayList<>();
        regulars.add(new Topping("lettuce", "regular", false));
        regulars.add(new Topping("tomato", "regular", false));
        regulars.add(new Topping("onion", "regular", false));
        regulars.add(new Topping("peppers", "regular", false));
        regulars.add(new Topping("jalapeños", "regular", false));
        regulars.add(new Topping("pickles", "regular", false));
        return regulars;
    }
}


/* this class is a topping selection this will be able to interact with my topping class and the cli
that i will code allowing the user to choose which toppings they would like
 */