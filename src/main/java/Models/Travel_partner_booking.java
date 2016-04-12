package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Travel_partner_booking {

    public int travel_product_orderline_id;
    public int travel_partner_id;

    public int getTravel_product_orderline_id() {
        return travel_product_orderline_id;
    }

    public void setTravel_product_orderline_id(int travel_product_orderline_id) {
        this.travel_product_orderline_id = travel_product_orderline_id;
    }

    public int getTravel_partner_id() {
        return travel_partner_id;
    }

    public void setTravel_partner_id(int travel_partner_id) {
        this.travel_partner_id = travel_partner_id;
    }
}
