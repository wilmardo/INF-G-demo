package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Shipment {

    public int invoice_id;
    public int shipment_method_id;
    public Date date;

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getShipment_method_id() {
        return shipment_method_id;
    }

    public void setShipment_method_id(int shipment_method_id) {
        this.shipment_method_id = shipment_method_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
