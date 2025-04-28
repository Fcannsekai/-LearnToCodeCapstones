package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                case "D" -> System.out.println("Test");
                case "P" -> System.out.println("marq");
                case "L" -> System.out.println("fred");
                case "X" -> System.exit(0);
                default -> System.out.println("Invalid input.");
            }
            homeScreen();
        }


    public void listOfTransactions(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile("\\|");

            while ((line = reader.readLine()) != null) {
                String[] tokens = pattern.split(line);

                if (tokens.length == 5) {
                    LocalDate date = LocalDate.parse(tokens[0].trim());
                    LocalTime time = LocalTime.parse(tokens[1].trim());
                    String description = tokens[2].trim();
                    String vendor = tokens[3].trim();
                    double amount = Double.parseDouble(tokens[4].trim());

                    Transactions tx = new Transactions(time, date, description, vendor, amount);
                    transactionsList.add(tx);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayTransactions() {
        for (Transactions tx : transactionsList) {
            System.out.println(tx);
        }
    }
}
