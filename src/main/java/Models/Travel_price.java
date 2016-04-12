package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Travel_price {

    public int travel_product_id;
    public Date start_date;
    public Date end_date;
    public float price;

    public int getTravel_product_id() {
        return travel_product_id;
    }

    public void setTravel_product_id(int travel_product_id) {
        this.travel_product_id = travel_product_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
