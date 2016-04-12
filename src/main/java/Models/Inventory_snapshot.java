package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Inventory_snapshot {

    public int physical_product_id;
    public int inventory_location_id;
    public Date date;
    public int amount;

    public int getPhysical_product_id() {
        return physical_product_id;
    }

    public void setPhysical_product_id(int physical_product_id) {
        this.physical_product_id = physical_product_id;
    }

    public int getInventory_location_id() {
        return inventory_location_id;
    }

    public void setInventory_location_id(int inventory_location_id) {
        this.inventory_location_id = inventory_location_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
