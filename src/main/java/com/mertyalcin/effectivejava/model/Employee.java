package com.mertyalcin.effectivejava.model;

import java.util.Date;

public class Employee implements Cloneable {
    private String name;
    private Date startDate;

    public Employee(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Yüzeysel kopya döndürür
    }
}
