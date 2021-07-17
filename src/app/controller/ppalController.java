package app.controller;

import app.util.ConfirmBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ppalController implements Initializable {
    AnchorPane srcPane = FXMLLoader.load(getClass().getResource("../vistas/inicio.fxml"));
    String strPath, strTitle = "";

    @FXML
    private Button btnStud, btnTeac, btnFees, btnUser, btnSett, btnClos;

    @FXML
    private AnchorPane pnlCont, pnlEnca, pnlTitl;

    @FXML
    private Label lblTitle, lblPath;

    public ppalController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        strPath = "index";
        strTitle = "Panel Principal";
        srcPane.setMinWidth(this.pnlCont.getWidth());
        srcPane.setMinHeight(this.pnlCont.getHeight());
        srcPane.setMaxWidth(this.pnlCont.getWidth());
        srcPane.setMaxHeight(this.pnlCont.getHeight());
        this.pnlCont.getChildren().setAll(srcPane);

    }

    @FXML
    public void handleClick(ActionEvent e) throws IOException {
        if (e.getSource() == btnStud) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/alumnos.fxml"));
            strPath = "alumnos";
            strTitle = "Control de Alumnos";
        }else if (e.getSource() == btnTeac) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/profesor.fxml"));
            strPath = "profesores";
            strTitle = "Control de Profesores";
        }else if (e.getSource() == btnFees) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/tarifa.fxml"));
            strPath = "tarifas";
            strTitle = "Control de Tarifas";
        }else if (e.getSource() == btnUser) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/usuario.fxml"));
            strPath = "usuarios";
            strTitle = "Control de Usuarios";
        }else if (e.getSource() == btnSett) {
            srcPane = FXMLLoader.load(getClass().getResource("../vistas/setting.fxml"));
            strPath = "configuracion";
            strTitle = "Control de Configuración";
        }else if (e.getSource() == btnClos) {
            Boolean Resp = ConfirmBox.display("Verifique su respuesta","Realmente desea salir");
            if (Resp == true) {
                System.exit(0);
            }
        }
        lblTitle.setText(strTitle);
        lblPath.setText(strPath);
        srcPane.prefWidth(this.pnlCont.getWidth());
        srcPane.prefHeight(this.pnlCont.getHeight());
        srcPane.setMinWidth(this.pnlCont.getWidth());
        srcPane.setMinHeight(this.pnlCont.getHeight());
        this.pnlCont.getChildren().setAll(srcPane);
    }
    private void Mnsg(String m) {
        JOptionPane.showMessageDialog( null,m,"Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
    }

}
