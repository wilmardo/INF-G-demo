package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Travel_excursion_booked {

    public int travel_product_orderline_id;
    public int travel_excursion_id;

    public int getTravel_product_orderline_id() {
        return travel_product_orderline_id;
    }

    public void setTravel_product_orderline_id(int travel_product_orderline_id) {
        this.travel_product_orderline_id = travel_product_orderline_id;
    }

    public int getTravel_excursion_id() {
        return travel_excursion_id;
    }

    public void setTravel_excursion_id(int travel_excursion_id) {
        this.travel_excursion_id = travel_excursion_id;
    }
}
