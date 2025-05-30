package com.pluralsight.food;

import java.util.List;
import java.util.Scanner;

public class ToppingSelectionHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static void addToppingsToSandwich(Sandwich sandwich) {

        List<Topping> meats = ToppingSelection.getMeatOptions(false);
        System.out.println("\n Meats ");
        for (int i = 0; i < meats.size(); i++) {
            System.out.println((i + 1) + ") " + meats.get(i).getName());
        }
        System.out.print("What meat would you like? ");
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            for (String tok : line.split("[,\\s]+")) {
                try {
                    int idx = Integer.parseInt(tok) - 1;
                    if (idx < 0 || idx >= meats.size()) continue;
                    Topping t = meats.get(idx);
                    sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
                    System.out.print("  Extra " + t.getName() + "? (yes/no): ");
                    if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                        sandwich.addTopping(new Topping(t.getName(), t.getType(), true));
                    }
                } catch (NumberFormatException e) {

                }
            }
        }

        List<Topping> cheeses = ToppingSelection.getCheeseOptions(false);
        System.out.println("\n Cheeses");
        for (int i = 0; i < cheeses.size(); i++) {
            System.out.println((i + 1) + ") " + cheeses.get(i).getName());
        }
        System.out.print(" PICK CHEESE NOW ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            for (String tok : line.split("[,\\s]+")) {
                try {
                    int idx = Integer.parseInt(tok) - 1;
                    if (idx < 0 || idx >= cheeses.size()) continue;
                    Topping t = cheeses.get(idx);
                    sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
                    System.out.print("  Extra " + t.getName() + "? (yes/no): ");
                    if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                        sandwich.addTopping(new Topping(t.getName(), t.getType(), true));
                    }
                } catch (NumberFormatException e) {

                }
            }
        }

        List<Topping> regulars = ToppingSelection.getRegularOptions();
        System.out.println("\n What veggies & sauces would you like? ");
        for (int i = 0; i < regulars.size(); i++) {
            System.out.println((i + 1) + ") " + regulars.get(i).getName());
        }
        System.out.print(" Please pick the toppings you'd like? ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            for (String tok : line.split("[,\\s]+")) {
                try {
                    int idx = Integer.parseInt(tok) - 1;
                    if (idx < 0 || idx >= regulars.size()) continue;
                    Topping t = regulars.get(idx);
                    sandwich.addTopping(new Topping(t.getName(), t.getType(), false));
                } catch (NumberFormatException e) {

                }
            }
        }
    }
}

/* this class is to help the user select what they want this will interact with sandwich and toppings ive added a
scanner that will guide these questions
 */