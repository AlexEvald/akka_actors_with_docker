package com.springdemo.demo.es;

import java.time.LocalDate;

public class EmployeePojo{
    public String firstName;
    public String lastName;
    private LocalDate startDate;

    private String type;

    public EmployeePojo(String firstName, String lastName, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }
    public EmployeePojo(String firstName, String lastName, LocalDate startDate,String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.type=type;
    }
    public EmployeePojo(String firstName, String lastName,String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.type=type;
    }

    public String name() {
        return this.firstName + " " + this.lastName;
    }

    public LocalDate getStart() {
        return this.startDate;
    }
}
