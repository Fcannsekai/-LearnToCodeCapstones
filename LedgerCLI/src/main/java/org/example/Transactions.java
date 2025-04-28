package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transactions {

    private LocalTime time;
    private LocalDate date;
    String description;
    String vendor;
    double faceValue;

    public Transactions(LocalTime time, LocalDate date, String description, String vendor, double faceValue) {
        this.time = time;
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.faceValue = faceValue;
    }
}
