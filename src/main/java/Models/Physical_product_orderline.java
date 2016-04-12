package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Physical_product_orderline {

    public int id;
    public int order_id;
    public int physical_product_id;
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

    public int getPhysical_product_id() {
        return physical_product_id;
    }

    public void setPhysical_product_id(int physical_product_id) {
        this.physical_product_id = physical_product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
