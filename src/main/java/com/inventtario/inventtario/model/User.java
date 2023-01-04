package com.inventtario.inventtario.model;

import com.inventtario.inventtario.util.Privilege;

import java.util.List;

public class User {

    private Long id;
    private String userName;
    private List<Privilege> privileges;
    private List<Customer> customerList;

}
