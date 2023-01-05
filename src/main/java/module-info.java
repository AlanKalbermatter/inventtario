module com.inventtario.inventtario {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires io.vertx.core;
    requires io.vertx.client.sql;
    requires io.vertx.client.sql.mysql;
    requires io.vertx.client.jdbc;

    opens com.inventtario to javafx.fxml;
    exports com.inventtario;
}