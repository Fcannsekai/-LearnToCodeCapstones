package com.pluralsight.food;

import java.util.List;
import java.util.Scanner;

public class ToppingSelectionHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static void addToppingsToSandwich(Sandwich sandwich) {

        List<Topping> meats = ToppingSelection.getMeatOptions(false);
        System.out.println("\n-- Meats --");
        for (int i = 0; i < meats.size(); i++) {
            System.out.println((i+1) + ") " + meats.get(i).getName());
        }
        System.out.print("Pick meats (comma-separated), or blank to skip: ");
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            for (String tok : line.split(",")) {
                int idx = Integer.parseInt(tok.trim()) - 1;
                Topping t = meats.get(idx);
                sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
                System.out.print("  Extra " + t.getName() + "? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    sandwich.addTopping(new Topping(t.getName(), t.getType(), true));
                }
            }
        }

        List<Topping> cheeses = ToppingSelection.getCheeseOptions(false);
        System.out.println("\n-- Cheeses --");
        for (int i = 0; i < cheeses.size(); i++) {
            System.out.println((i+1) + ") " + cheeses.get(i).getName());
        }
        System.out.print("Pick cheeses, or blank to skip: ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            for (String tok : line.split(",")) {
                int idx = Integer.parseInt(tok.trim()) - 1;
                Topping t = cheeses.get(idx);
                sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
                System.out.print("  Extra " + t.getName() + "? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    sandwich.addTopping(new Topping(t.getName(), t.getType(), true));
                }
            }
        }

        List<Topping> regulars = ToppingSelection.getRegularOptions();
        System.out.println("\n-- Veggies & Sauces --");
        for (int i = 0; i < regulars.size(); i++) {
            System.out.println((i+1) + ") " + regulars.get(i).getName());
        }
        System.out.print("Pick regular toppings, or blank to skip: ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            for (String tok : line.split(",")) {
                int idx = Integer.parseInt(tok.trim()) - 1;
                Topping t = regulars.get(idx);
                sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
            }
        }
    }
}

/* this class is to help the user select what they want this will interact with sandwich and toppings ive added a
scanner that will guide these questions
 */