package app.model;

import app.entity.Datos_persoEntity;
import app.util.AlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class datos_persoModel {

    public static ObservableList<Datos_persoEntity> getDatos_perso() throws SQLException {
        ObservableList<Datos_persoEntity> PrsoList = FXCollections.observableArrayList();
        Connection oConn = oconnect.Connect();
        String sSql = "SELECT id, cedula, nombre, apellido, sexo, " +
                "             fecnac, telefono, direccion, email" +
                "      FROM datos_personales";
        Statement st;
        ResultSet rs;
        try {
            st = oConn.createStatement();
            rs = st.executeQuery(sSql);
            Datos_persoEntity datos;
            while (rs.next()) {
                datos = new Datos_persoEntity(
                        rs.getInt("id"),
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("sexo"),
                        rs.getDate("fecnac"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                );
                PrsoList.add(datos);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        oconnect.CerrarConn();
        return PrsoList;
    }

    public static ObservableList<Datos_persoEntity> getDatos_persoID(Integer iCodi) throws SQLException {
        ObservableList<Datos_persoEntity> PrsoList = FXCollections.observableArrayList();
        Connection oConn = oconnect.Connect();
        String sSql = "SELECT id, cedula, nombre, apellido, sexo, " +
                "             fecnac, telefono, direccion, email" +
                "      FROM datos_personales" +
                "      WHERE id = ?";


        try {
            PreparedStatement pSt = oConn.prepareStatement(sSql);
            pSt.setInt(1, iCodi);
            ResultSet rs;

            rs = pSt.executeQuery(sSql);

            Datos_persoEntity datos;
            while (rs.next()) {
                datos = new Datos_persoEntity(
                        rs.getInt("id"),
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("sexo"),
                        rs.getDate("fecnac"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email")
                );
                PrsoList.add(datos);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        oconnect.CerrarConn();
        return PrsoList;
    }

    public static void insertRecord(String sCedu, String sNomb, String sApel, String sSexo, Date dFecn, String sTele, String sDire, String sEmai) throws SQLException {
        Connection oConn = oconnect.Connect();
        String sSql = "INSERT INTO datos_personales(cedula, nombre, apellido, sexo, " +
                "             fecnac, telefono, direccion, email)" +
                "      VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pSt = oConn.prepareStatement(sSql);

            pSt.setString(1, sCedu.toString());
            pSt.setString(2, sNomb.toString());
            pSt.setString(3, sApel.toString());
            pSt.setString(4, sSexo.toString());
            pSt.setDate(5, dFecn);
            pSt.setString(6, sTele.toString());
            pSt.setString(7, sDire.toString());
            pSt.setString(8, sEmai.toString());

            pSt.execute();
            oconnect.CerrarConn();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateRecord(Integer iCodi, String sCedu, String sNomb, String sApel, String sSexo, Date dFecn, String sTele, String sDire, String sEmai) throws SQLException {
        Connection oConn = oconnect.Connect();
        String sSql = "UPDATE datos_personales SET cedula = ?, nombre = ?, apellido = ?, sexo = ?, " +
                            "fecnac = ?, telefono = ?, direccion = ?, email = ? " +
                            "WHERE id = ?";

        try {
            PreparedStatement pSt = oConn.prepareStatement(sSql);

            pSt.setString(1, sCedu.toString());
            pSt.setString(2, sNomb.toString());
            pSt.setString(3, sApel.toString());
            pSt.setString(4, sSexo.toString());
            pSt.setDate(5, dFecn);
            pSt.setString(6, sTele.toString());
            pSt.setString(7, sDire.toString());
            pSt.setString(8, sEmai.toString());
            pSt.setInt(9, iCodi);

            pSt.execute();
            oconnect.CerrarConn();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(Integer iCodi) throws SQLException {
        Connection oConn = oconnect.Connect();
        String sSql = "DELETE FROM datos_personales " +
                "      WHERE id = ?";
        try {
            PreparedStatement pSt = oConn.prepareStatement(sSql);
            pSt.setInt(1, iCodi);
            pSt.execute();
            oconnect.CerrarConn();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
