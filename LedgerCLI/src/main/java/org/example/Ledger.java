package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ledger {

        private List<Transactions> transactionsList = new ArrayList<>();

        public void homeScreen() { // homescreen display
            Scanner scanner = new Scanner(System.in);
            System.out.print("Welcome, what would you like to do today?\n" +
                    "D) Add Deposit\n" +
                    "P) Make Payment\n" +
                    "L) Ledger\n" +
                    "X) Exit\n" +
                    ">");

            String filePath = scanner.nextLine().trim().toUpperCase(); // for case sensitivity purposes

            switch (filePath) {  // switch case instead of else if to improve readability and shorten code
                case "D" -> System.out.println("test");
                case "P" -> System.out.println("marq");
                case "L" -> System.out.println("fred");
                case "X" -> System.exit(0);
                default -> System.out.println("Invalid input.");
            }
            homeScreen();
        }
}
