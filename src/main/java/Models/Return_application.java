package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Return_application {

    public int id;
    public int invoice_id;
    public Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }
}
