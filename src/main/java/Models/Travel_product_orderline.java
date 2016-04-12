package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Travel_product_orderline {

    public int id;
    public int order_id;
    public int travel_product_id;
    public int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getTravel_product_id() {
        return travel_product_id;
    }

    public void setTravel_product_id(int travel_product_id) {
        this.travel_product_id = travel_product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
