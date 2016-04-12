package com.company.Models;

import java.sql.Date;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Employee {

    public int id;
    public int job_title_id;
    public String first_name;
    public String last_name;
    public String phone;
    public String email;
    public String address;
    public String postal_code;
    public String city;
    public String state;
    public int country_id;
    public String work_fax;
    public String work_phone;
    public String work_email;
    public float salary;
    public String social_security_number;
    public Date start_date;
    public Date termination_date;
    public Date birth_date;
    public char sex;
    public int health_insurence;
    public int life_insurence;
    public int day_care;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJob_title_id() {
        return job_title_id;
    }

    public void setJob_title_id(int job_title_id) {
        this.job_title_id = job_title_id;
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

    public String getWork_fax() {
        return work_fax;
    }

    public void setWork_fax(String work_fax) {
        this.work_fax = work_fax;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getWork_email() {
        return work_email;
    }

    public void setWork_email(String work_email) {
        this.work_email = work_email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getSocial_security_number() {
        return social_security_number;
    }

    public void setSocial_security_number(String social_security_number) {
        this.social_security_number = social_security_number;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getTermination_date() {
        return termination_date;
    }

    public void setTermination_date(Date termination_date) {
        this.termination_date = termination_date;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getHealth_insurence() {
        return health_insurence;
    }

    public void setHealth_insurence(int health_insurence) {
        this.health_insurence = health_insurence;
    }

    public int getLife_insurence() {
        return life_insurence;
    }

    public void setLife_insurence(int life_insurence) {
        this.life_insurence = life_insurence;
    }

    public int getDay_care() {
        return day_care;
    }

    public void setDay_care(int day_care) {
        this.day_care = day_care;
    }
}
