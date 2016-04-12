package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Return_product {

    public int return_application_id;
    public int physical_product_orderline_id;
    public String reason;

    public int getReturn_application_id() {
        return return_application_id;
    }

    public void setReturn_application_id(int return_application_id) {
        this.return_application_id = return_application_id;
    }

    public int getPhysical_product_orderline_id() {
        return physical_product_orderline_id;
    }

    public void setPhysical_product_orderline_id(int physical_product_orderline_id) {
        this.physical_product_orderline_id = physical_product_orderline_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
