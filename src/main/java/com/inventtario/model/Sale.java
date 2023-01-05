package com.inventtario.model;

import java.util.List;
import java.sql.Date;

public class Sale {

    private Long id;
    private List<Item> listOfItems;
    private double subTotal;
    private double total;
    private int discount;
    private Date salesDate;
    private Customer customer;

}
