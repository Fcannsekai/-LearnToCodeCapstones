package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ledger {

    private List<Transactions> transactionsList = new ArrayList<>();

    public void homeScreen() { // homescreen display
        Scanner scanner = new Scanner(System.in);
        listOfTransactions();
        System.out.print("Welcome, what would you like to do today?\n" +
                "D) Add Deposit\n" +
                "P) Make Payment\n" +
                "L) Ledger\n" +
                "X) Exit\n" +
                ">");

        String filePath = scanner.nextLine().trim().toUpperCase(); // for case sensitivity purposes

        switch (filePath) {  // switch case instead of else if to improve readability and shorten code
            case "D" -> addTransaction(true);
            case "P" -> addTransaction(false); // Lambda syntax used to clean up code
            case "L" -> ledgerMenu();
            case "X" -> System.exit(0);
            default -> System.out.println("Invalid input.");
        }
        homeScreen();
    }


    public void addTransaction(boolean isDeposit) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (!isDeposit) {
            amount = -amount;
        }

        Transactions tx = new Transactions(LocalTime.now(), LocalDate.now(), description, vendor, amount);
        appendTransactionToFile(tx);
        System.out.println("Transaction saved.");
    }

    private void appendTransactionToFile(Transactions tx) {

        try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter("Transactions.csv", true);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // write to the file
            String text = "";
            // for (int i = 1; i <= 10; i++) { old code
            DateTimeFormatter timeWithAmPm = DateTimeFormatter.ofPattern("HH:mm:ss"); //changed time format
            LocalTime formattedTime = LocalTime.parse(tx.getTime().format(timeWithAmPm));
            text = String.format(tx.getDate() + "|" + formattedTime + "|" + tx.getDescription() + "|" + tx.getVendor() + "|" + tx.getFaceValue());

            bufWriter.write(text + "\n");
            // close the writer
            bufWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();

        }
    }


    public void listOfTransactions() {
        transactionsList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String line;
            Pattern pattern = Pattern.compile("\\|");

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = pattern.split(line);

                if (tokens.length == 5) {
                    LocalDate date = LocalDate.parse(tokens[0].trim());
                    LocalTime time = LocalTime.parse(tokens[1].trim());
                    String description = tokens[2].trim();
                    String vendor = tokens[3].trim();
                    double amount = Double.parseDouble(tokens[4]);

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
            tx.displayTransaction();
        }

    }


    public void displayDeposits() {
        for (Transactions tx : transactionsList) {
            if (tx.getFaceValue() > 0) {
                tx.displayTransaction();
            }
        }
    }


    public void displayPayments() {
        for (Transactions tx : transactionsList) {
            if (tx.getFaceValue() < 0) {
                tx.displayTransaction();
            }
        }
    }

    public void ledgerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ledger Menu\n" +
        "A) All\n" +
        "D) Deposits\n" +
        "P) Payments\n" +
        "R) Reports\n" +
        "H) Home\n" +
        ">");

        String choice = scanner.nextLine().trim().toUpperCase();

        switch (choice) {
            case "A" -> displayTransactions();
            case "D" -> displayDeposits();
            case "P" -> displayPayments();
            case "R" -> reportsMenu();
            case "H" -> homeScreen();
            default -> System.out.println("Invalid input.");
        }

        ledgerMenu(); // Recursion loop
    }

    public void reportsMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the reports menu\n" +
                "1) Month To Date\n" +
                "2) Previous Month\n" +
                "3) Year To Date\n" +
                "4) Previous Year\n" +
                "5) Search by Vendor\n" +
                "0) Back\n" +
                ">");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> monthToDate();
            case "2" -> previousMonth();
            case "3" -> yearToDate();
            case "4" -> previousYear();
            case "5" -> searchByVendor();
            case "0" -> {
                ledgerMenu();
                return;
            }
            default -> System.out.println("Invalid input.");
        }

        reportsMenu();
    }
    //----------------------------------------------------->  switch to individual methods for each case for clarity.
    public void monthToDate() {
        LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
        for (Transactions tx : transactionsList) {
            if (!tx.getDate().isBefore(firstDay)) {
                tx.displayTransaction();
            }
        }
    }

    public void previousMonth() {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusMonths(1).withDayOfMonth(1);
        LocalDate end = now.withDayOfMonth(1).minusDays(1);

        for (Transactions tx : transactionsList) {
            if (!tx.getDate().isBefore(start) && !tx.getDate().isAfter(end)) {
                tx.displayTransaction();
            }
        }
    }

    public void yearToDate() {
        LocalDate start = LocalDate.now().withDayOfYear(1);
        for (Transactions tx : transactionsList) {
            if (!tx.getDate().isBefore(start)) {
                tx.displayTransaction();
            }
        }
    }

    public void previousYear() {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusYears(1).withDayOfYear(1);
        LocalDate end = now.withDayOfYear(1).minusDays(1);

        for (Transactions tx : transactionsList) {
            if (!tx.getDate().isBefore(start) && !tx.getDate().isAfter(end)) {
                tx.displayTransaction();
            }
        }
    }

    public void searchByVendor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vendor name to search: ");  // Easiest part of the project LOL
        String vendorSearch = scanner.nextLine().trim().toLowerCase();

        for (Transactions tx : transactionsList) {
            if (tx.getVendor().toLowerCase().contains(vendorSearch)) {
                tx.displayTransaction();
            }
        }
    }
}


