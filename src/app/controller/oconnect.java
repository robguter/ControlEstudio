package app.controller;

import app.util.AlertBox;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class oconnect implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String jConn = "jdbc:postgresql://localhost:5432/ctrl_estudio";
        String sUser = "Robguter";
        String sPass = "414345";
        try {
            Connection oConn = DriverManager.getConnection(jConn,sUser,sPass);
            AlertBox.display("Connection successfully","Connected to PostgreSQL server");

            oConn.close();
        } catch (Exception e) {
            AlertBox.display("Connection error","Error connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }
}
