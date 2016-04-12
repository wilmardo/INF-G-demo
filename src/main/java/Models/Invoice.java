package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Invoice {

    public int id;
    public int order_id;
    public Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
