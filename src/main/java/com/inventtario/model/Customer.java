package com.inventtario.model;

import java.sql.Date;
import java.util.List;

public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Long phone;
    private Date birthDate;
    private List<Item> conditionalItems;
    private List<Sale> completedSales;

    public Customer(String id, String firstName, String lastName, String address,
                    Date birthDate, List<Item> conditionalItems, List<Sale> completedSales,
                    String email, Long phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
        this.conditionalItems = conditionalItems;
        this.completedSales = completedSales;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Item> getConditionalItems() {
        return conditionalItems;
    }

    public void setConditionalItems(List<Item> conditionalItems) {
        this.conditionalItems = conditionalItems;
    }

    public List<Sale> getCompletedSales() {
        return completedSales;
    }

    public void setCompletedSales(List<Sale> completedSales) {
        this.completedSales = completedSales;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
