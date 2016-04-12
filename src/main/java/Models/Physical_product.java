package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Physical_product {

    public int product_id;
    public int phyiscal_product_type_id;
    public int supplier_id;
    public String name;
    public String description;
    public String size;
    public String color;
    public float purchasing_price;
    public float selling_price;
    public String image;
    public Date introduction_date;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPhyiscal_product_type_id() {
        return phyiscal_product_type_id;
    }

    public void setPhyiscal_product_type_id(int phyiscal_product_type_id) {
        this.phyiscal_product_type_id = phyiscal_product_type_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPurchasing_price() {
        return purchasing_price;
    }

    public void setPurchasing_price(float purchasing_price) {
        this.purchasing_price = purchasing_price;
    }

    public float getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getIntroduction_date() {
        return introduction_date;
    }

    public void setIntroduction_date(Date introduction_date) {
        this.introduction_date = introduction_date;
    }
}
