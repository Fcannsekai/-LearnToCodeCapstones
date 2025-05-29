package com.pluralsight.ui;

import com.pluralsight.interfaces.Order;
import com.pluralsight.food.Sandwich;
import com.pluralsight.food.Drink;
import com.pluralsight.food.Chip;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {
        try {

            File dir = new File("receipts");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            File file = new File(dir, timestamp + ".txt");

            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                out.println("X===> Bay City Subs Receipt <===X");
                out.println("Order Time: " + timestamp);
                out.println();

                for (Sandwich s : order.getSandwiches()) {
                    out.println(s);
                }
                for (Drink d : order.getDrinks()) {
                    out.println(d);
                }
                for (Chip c : order.getChips()) {
                    out.println(c);
                }

                double total = order.getTotalPrice();
                double roundedTotal = Math.round(total * 100) / 100.0;
                out.println();
                out.println("Total: $" + roundedTotal);
                out.println();
                out.println("Thank you for your order!");
            }

            System.out.println("Thank you! Receipt saved to: " + file.getPath());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}