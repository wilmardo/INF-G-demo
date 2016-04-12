package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Physical_product_type {

    public int id;
    public int physical_product_group_id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhysical_product_group_id() {
        return physical_product_group_id;
    }

    public void setPhysical_product_group_id(int physical_product_group_id) {
        this.physical_product_group_id = physical_product_group_id;
    }
}
