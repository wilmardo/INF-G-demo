package com.company.Models;

import java.sql.Time;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Travel_product {

    public int product_id;
    public int travel_product_method_id;
    public String name;
    public String description;
    public Time duration;
    public int travel_product_location_id;
    public float price;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getTravel_product_method_id() {
        return travel_product_method_id;
    }

    public void setTravel_product_method_id(int travel_product_method_id) {
        this.travel_product_method_id = travel_product_method_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getTravel_product_location_id() {
        return travel_product_location_id;
    }

    public void setTravel_product_location_id(int travel_product_location_id) {
        this.travel_product_location_id = travel_product_location_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
