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
import java.util.ArrayList;
import java.util.List;

public class ReceiptWriter {

    private static final String STORE_NAME    = "Bay City Subs";
    private static final String STORE_ADDRESS = "123 Mind Ya Buisness, USA";
    private static final String STORE_PHONE   = "(415) 555 6969";

    public static void saveReceipt(Order order) {
        try {
            File dir = new File("receipts");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            LocalDateTime now = LocalDateTime.now();
            String fileTimestamp    = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String displayTimestamp = now.format(DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss"));
            File file = new File(dir, fileTimestamp + ".txt");

            List<String> lines = new ArrayList<>();
            lines.add(STORE_NAME);
            lines.add("Address: " + STORE_ADDRESS);
            lines.add("Phone:   " + STORE_PHONE);
            lines.add("Date:    " + displayTimestamp);
            lines.add("");

            for (Sandwich s : order.getSandwiches()) {
                lines.add(s.toString());
            }
            for (Drink d : order.getDrinks()) {
                lines.add(d.toString());
            }
            for (Chip c : order.getChips()) {
                lines.add(c.toString());
            }
            lines.add("");

            double total = order.getTotalPrice();
            double roundedTotal = Math.round(total * 100) / 100.0;
            lines.add("Total:   $" + roundedTotal);

            int max = 0;
            for (String ln : lines) {
                if (ln.length() > max) max = ln.length();
            }
            int width = max + 4;

            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                out.println("+" + "-".repeat(width - 2) + "+");
                for (String ln : lines) {
                    int paddingCount = max - ln.length();
                    String padding = " ".repeat(paddingCount);
                    out.println("| " + ln + padding + " |");
                }

                out.println("+" + "-".repeat(width - 2) + "+");
            }

            System.out.println(" Receipt saved to: " + file.getPath());
        } catch (IOException e) {
            System.out.println(" Error receipt not saved: " + e.getMessage());
        }
    }
}
