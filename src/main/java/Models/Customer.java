package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Customer {

    public int id;
    public int business_branch_id;
    public String first_name;
    public String last_name;
    public String phone;
    public String email;
    public String address;
    public String postal_code;
    public String city;
    public String state;
    public int country_id;
    public String invoice_address;
    public String invoice_postal_code;
    public String invoice_city;
    public String invoice_state;
    public int invoice_country_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusiness_branch_id() {
        return business_branch_id;
    }

    public void setBusiness_branch_id(int business_branch_id) {
        this.business_branch_id = business_branch_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getInvoice_address() {
        return invoice_address;
    }

    public void setInvoice_address(String invoice_address) {
        this.invoice_address = invoice_address;
    }

    public String getInvoice_postal_code() {
        return invoice_postal_code;
    }

    public void setInvoice_postal_code(String invoice_postal_code) {
        this.invoice_postal_code = invoice_postal_code;
    }

    public String getInvoice_city() {
        return invoice_city;
    }

    public void setInvoice_city(String invoice_city) {
        this.invoice_city = invoice_city;
    }

    public String getInvoice_state() {
        return invoice_state;
    }

    public void setInvoice_state(String invoice_state) {
        this.invoice_state = invoice_state;
    }

    public int getInvoice_country_id() {
        return invoice_country_id;
    }

    public void setInvoice_country_id(int invoice_country_id) {
        this.invoice_country_id = invoice_country_id;
    }
}
