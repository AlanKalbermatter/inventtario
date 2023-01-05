package com.inventtario.dao;

import com.inventtario.consts.BaseQueries;
import com.inventtario.model.Customer;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO extends BaseDBClient implements BaseQueries {
    private BaseDBClient dbClient;

    public CustomerDAO(Vertx vertx) {
        super(vertx);
    }

    public void addCustomer(Customer customerToAdd) {
        final JsonArray params =
                new JsonArray()
                        .add(customerToAdd.getFirstName())
                        .add(customerToAdd.getLastName())
                        .add(customerToAdd.getAddress())
                        .add(customerToAdd.getBirthDate())
                        .add(customerToAdd.getEmail())
                        .add(customerToAdd.getPhone());
        dbClient.add(ADD_CUSTOMER, params);
    }

    public void deleteCustomer(String id) {
        final JsonArray params = new JsonArray().add(id);
        dbClient.add(DELETE_CUSTOMER, params);
    }

    public void updateCustomer(Customer customerToUpdate) {
        final JsonArray params =
                new JsonArray()
                        .add(customerToUpdate.getFirstName())
                        .add(customerToUpdate.getLastName())
                        .add(customerToUpdate.getAddress())
                        .add(customerToUpdate.getBirthDate())
                        .add(customerToUpdate.getEmail())
                        .add(customerToUpdate.getPhone())
                        .add(customerToUpdate.getId());
        dbClient.add(UPDATE_CUSTOMER, params);
    }

    public Customer retrieveCustomer(Optional<String> firstName, Optional<String> lastName) {
        List<String> params = new ArrayList<>();
        if (firstName.isPresent() && lastName.isPresent()) {
            params.add(firstName.get());
            params.add(lastName.get());
        } else if (firstName.isPresent()) {
            params.add(firstName.get());
        } else {
            //TODO: throw custom exception;
        }
        Future<JsonArray> retrievedCustomers = dbClient.retrieve(prepareStatement(RETRIEVE_CUSTOMER, params));;

        // treat the error response
        retrievedCustomers.onComplete(ar -> {
            if (ar.failed()){
                //Forward error
                retrievedCustomers.failed();
            }
        });
        // Return response
        return new Customer(
                retrievedCustomers.result().getString(0),
                retrievedCustomers.result().getString(1),
                retrievedCustomers.result().getString(2),
                retrievedCustomers.result().getString(3),
                Date.valueOf(retrievedCustomers.result().getString(4)),
                null,
                null,
                retrievedCustomers.result().getString(5),
                retrievedCustomers.result().getLong(6)
        );
    }
}
