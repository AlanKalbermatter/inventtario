package com.inventtario.consts;

public interface BaseQueries {

    String ADD_CUSTOMER = "INSERT INTO customer (first_name, last_name, address, birth_date, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
    String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";
    String UPDATE_CUSTOMER = "UPDATE customer SET first_name = ?, last_name = ?, address = ?, birth_date = ?, email = ?, phone = ? WHERE id = ?";
    String RETRIEVE_CUSTOMER = "SELECT * FROM customer WHERE first_name = nfirst_name AND last_name = nnlast_name";

}
