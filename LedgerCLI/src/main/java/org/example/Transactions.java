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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }
}
