package hu.bencelaszlo.mybatis;

import java.util.Date;


/**
 * Represents a car.
 */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets manufacture date.
     *
     * @return the manufacture date
     */
    public Date getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Sets manufacture date.
     *
     * @param manufactureDate the manufacture date
     */
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}