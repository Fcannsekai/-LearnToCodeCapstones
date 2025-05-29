package com.pluralsight.ui;

import java.util.Scanner;
import com.pluralsight.interfaces.Order;

public class HomeScreen {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("\n=== Bay City Subs ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("> ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    Order order = new Order();
                    OrderMenu orderMenu = new OrderMenu();
                    orderMenu.display(order);
                }
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

//this class is simple enough it just lets users start new orders and exit the process correctly