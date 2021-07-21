package app.model;

import app.util.AlertBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class oconnect {

    static Connection oConn;
    public static Connection Connect() {
        String jConn = "jdbc:postgresql://localhost:5432/ctrl_estudio";
        String sUser = "Robguter";
        String sPass = "414345";
        try {
            oConn = DriverManager.getConnection(jConn,sUser,sPass);
            //AlertBox.display("Connection successfully","Connected to PostgreSQL server");
            //oConn.close();
        } catch (Exception e) {
            AlertBox.display("Connection error","Error connecting to PostgreSQL server");
            e.printStackTrace();
        }
        return oConn;
    }

    public static void CerrarConn() throws SQLException {
        oConn.close();
    }
}
