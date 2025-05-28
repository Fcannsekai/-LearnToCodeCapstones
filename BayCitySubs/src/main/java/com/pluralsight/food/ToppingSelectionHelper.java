package com.pluralsight.food;

import java.util.List;
import java.util.Scanner;

public class ToppingSelectionHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static void addToppingsToSandwich(Sandwich sandwich) {
        List<Topping> meats = ToppingSelection.getMeatOptions(false);  //this is for meat selection.
        System.out.println("\n-- Meats --");
        for (int i = 0; i < meats.size(); i++) {
            System.out.println((i + 1) + ") " + meats.get(i).getName());
        }
        System.out.print("Pick meat numbers (comma separated), or leave blank: ");
        String meatInput = scanner.nextLine();
        if (!meatInput.isEmpty()) {
            for (String choice : meatInput.split(",")) {
                int index = Integer.parseInt(choice.trim()) - 1;
                Topping t = meats.get(index);
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
            System.out.println((i + 1) + ") " + cheeses.get(i).getName());
        }
        System.out.print("Pick cheese numbers, or leave blank: ");   // this is for cheese selection
        String cheeseInput = scanner.nextLine();
        if (!cheeseInput.isEmpty()) {
            for (String choice : cheeseInput.split(",")) {
                int index = Integer.parseInt(choice.trim()) - 1;
                Topping t = cheeses.get(index);
                sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
                System.out.print("  Extra " + t.getName() + "? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    sandwich.addTopping(new Topping(t.getName(), t.getType(), true));
                }
            }
        }

        // Regular Toppings
        List<Topping> regulars = ToppingSelection.getRegularOptions();
        System.out.println("\n-- Regular Toppings --");
        for (int i = 0; i < regulars.size(); i++) {
            System.out.println((i + 1) + ") " + regulars.get(i).getName());  //this is for topping selection
        }
        System.out.print("Pick regular topping numbers, or leave blank: ");
        String regInput = scanner.nextLine();
        if (!regInput.isEmpty()) {
            for (String choice : regInput.split(",")) {
                int index = Integer.parseInt(choice.trim()) - 1;
                Topping t = regulars.get(index);
                sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
            }
        }
    }
}

/* this class is to help the user select what they want this will interact with sandwich and toppings ive added a
scanner that will guide these questions
 */