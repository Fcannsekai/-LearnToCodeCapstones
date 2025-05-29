package com.pluralsight.ui;

import java.util.Scanner;
import com.pluralsight.interfaces.Order;
import com.pluralsight.food.Sandwich;
import com.pluralsight.food.Drink;
import com.pluralsight.food.Chip;
import com.pluralsight.food.ToppingSelectionHelper;

public class OrderMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void display(Order order) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("> ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addSandwich(order);
                case "2" -> addDrink(order);
                case "3" -> addChips(order);
                case "4" -> {
                    checkout(order);
                    running = false;
                }
                case "0" -> {
                    System.out.println("Order canceled. Returning to home.");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSandwich(Order order) {
        System.out.println("\n-- Build Your Sandwich --");
        System.out.println("Choose size: 1) 4\"  2) 8\"  3) 12\"");
        System.out.print("> ");
        String size = switch (scanner.nextLine().trim()) {
            case "1" -> "4";
            case "2" -> "8";
            case "3" -> "12";
            default -> {
                System.out.println("Invalid, defaulting to 8\".");
                yield "8";
            }
        };

        System.out.println("Choose bread type: 1) White  2) Rosemary Garlic  3) Sourdough  4) Garlic Knot");
        System.out.print("> ");
        String bread = switch (scanner.nextLine().trim()) {
            case "1" -> "white";
            case "2" -> "rosemary garlic";
            case "3" -> "sourdough";
            case "4" -> "garlic knot";
            default -> {
                System.out.println("Invalid, defaulting to white.");
                yield "white";
            }
        };

        System.out.print("To toast? (yes/no): ");
        boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);
        ToppingSelectionHelper.addToppingsToSandwich(sandwich);

        System.out.println("\nSandwich Summary:");
        System.out.println(sandwich);
        System.out.print("Add this sandwich to your order? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            order.addSandwich(sandwich);
            System.out.println("Sandwich added.");
        } else {
            System.out.println("Sandwich discarded.");
        }
    }

    private void addDrink(Order order) {
        System.out.println("\n-- Add Drink --");
        System.out.print("Enter drink size (Small, Medium, Large): ");
        String size = scanner.nextLine().trim();
        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine().trim();
        Drink drink = new Drink(size, flavor);
        order.addDrink(drink);
        System.out.println("✅ Drink added.");
    }

    private void addChips(Order order) {
        System.out.println("\n-- Add Chips --");
        System.out.print("Enter chip flavor: ");
        String flavor = scanner.nextLine().trim();
        Chip chip = new Chip(flavor);
        order.addChips(chip);
        System.out.println("✅ Chips added.");
    }

    private void checkout(Order order) {
        double total = 0;
        System.out.println("\n🧾 Order Summary:");
        for (Sandwich s : order.getSandwiches()) {
            System.out.println(s);
            total += s.getPrice();
        }
        for (Drink d : order.getDrinks()) {
            System.out.println(d);
            total += d.getPrice();
        }
        for (Chip c : order.getChips()) {
            System.out.println(c);
            total += c.getPrice();
        }

        double roundedTotal = Math.round(total * 100) / 100.0;
        System.out.println("💵 Total: $" + roundedTotal);

        System.out.print("Confirm order? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            System.out.println(" Order confirmed! Thank you.");
        } else {
            System.out.println(" Order not confirmed.");
        }
    }
}