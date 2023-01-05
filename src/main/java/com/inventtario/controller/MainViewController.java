package com.inventtario.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private AnchorPane paneRight;
    @FXML
    private AnchorPane paneLeft;
    private HashMap<String, String> FXML_URL = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
