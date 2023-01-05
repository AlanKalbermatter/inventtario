package com.inventtario.dao;

import com.inventtario.consts.BaseDBParams;
import com.inventtario.consts.CommonConst;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLClient;

import java.util.List;

public class BaseDBClient implements BaseDBParams, CommonConst {

    private SQLClient client;

    public BaseDBClient(Vertx vertx) {
        final JsonObject config = new JsonObject();
        config.put(C_URL, URL);
        config.put(C_DRIVER_CLASS, DRIVER_CLASS);
        config.put(C_USER, USER);
        config.put(C_PASSWORD, PASSWORD); //For production manage password in config file or through env
        client = JDBCClient.createShared(vertx, config);
    }

    protected String prepareStatement(String query, List<String> params) {
        for (String param : params) {
            query = query.replaceFirst("\\?", param);
        }
        return query;
    }

    public Future<Void> add(String query, JsonArray params) {
        final Promise<Void> added = Promise.promise();
        client.updateWithParams(query, params, ar -> {
            if (ar.failed()){
                //Forward error
                added.fail(ar.cause());
                return;
            }
            //Return failure if updated count is not 1
            if (ar.result().getUpdated() != 1) {
                added.fail(new IllegalStateException("Wrong update count on insert " + ar.result()));
                return;
            }
            //Return success
            added.complete();
        });
        return added.future();
    }

    public Future<JsonArray> retrieve(String query) {
        final Promise<JsonArray> retrieved = Promise.promise();
        client
            .query(query, ar -> {
                if (ar.failed()){
                    //Forward error
                    retrieved.fail(ar.cause());
                    return;
                }
                //Return result
                final List<JsonObject> rows = ar.result().getRows();
                final JsonArray result = new JsonArray();
                rows.forEach(result::add);
                retrieved.complete(result);
            });
        return retrieved.future();
    }

    public Future<Void> delete(String query, JsonArray params) {
        final Promise<Void> deleted = Promise.promise();
        client.updateWithParams(query, params, ar -> {
            if (ar.failed()){
                //Forward error
                deleted.fail(ar.cause());
                return;
            }
            //Nothing was deleted
            if (ar.result().getUpdated() == 0) {
                deleted.complete();
            }
        });
        return deleted.future();
    }

    public Future<Void> update(String query, JsonArray params) {
        final Promise<Void> updated = Promise.promise();
        client.updateWithParams(query, params, ar -> {
            if (ar.failed()){
                //Forward error
                updated.fail(ar.cause());
                return;
            }
            //Nothing was updated
            if (ar.result().getUpdated() == 0) {
                updated.complete();
            }
        });
        return updated.future();
    }

}
