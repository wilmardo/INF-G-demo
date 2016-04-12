package com.company.Models;

/**
 * Created by nektariosevangelou on 11/04/16.
 */
public class Job_title {

    public int id;
    public int department_branch_id;
    public String name;
    public String description;
    public float min_salary;
    public float max_salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_branch_id() {
        return department_branch_id;
    }

    public void setDepartment_branch_id(int department_branch_id) {
        this.department_branch_id = department_branch_id;
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

    public float getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(float min_salary) {
        this.min_salary = min_salary;
    }

    public float getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(float max_salary) {
        this.max_salary = max_salary;
    }
}
