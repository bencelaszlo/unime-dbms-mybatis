package hu.bencelaszlo.mybatis;

import java.util.Date;

public class Car {
    private int id;
    private String color;
    private String brand;
    private String model;
    private Date manufactureDate;

    @Override
    public String toString() {
        return "| " + this.id + " | " + this.brand + " | " + this.model + " | " + this.color + " | " + this.manufactureDate + " |";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}