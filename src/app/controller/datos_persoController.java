package app.controller;

import app.entity.Datos_persoEntity;
import app.model.datos_persoModel;
import app.util.ConfirmBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;

import java.util.Locale;
import java.util.ResourceBundle;

public class datos_persoController implements Initializable {

    String sSexo = "M";
    Boolean bAdd, bEdt = false;
    Integer iIndx = 0;
    ObservableList<Datos_persoEntity> PrsoList;

    @FXML
    private TextField tfCodi, tfCedu, tfNomb, tfApel, tfTele, tfDire, tfEmai;

    @FXML
    private ToggleGroup gSexo;

    @FXML
    private RadioButton optM, optF;

    @FXML
    private DatePicker dpFecn;

    @FXML
    private Button btnAgregar, btnGuardar, btnEditar, btnCancelar, btnEliminar,
                    btnSalir, btnPrim, btnAnte, btnSigu, btnUlti;

    @FXML
    private Label lblReg;

    @FXML
    private TableView<Datos_persoEntity> tvDatosPerso;

    @FXML
    private TableColumn<Datos_persoEntity, Integer> colCodi;

    @FXML
    private TableColumn<Datos_persoEntity, String> colCedu;

    @FXML
    private TableColumn<Datos_persoEntity, String> colNomb;

    @FXML
    private TableColumn<Datos_persoEntity, String> colApel;

    @FXML
    private TableColumn<Datos_persoEntity, Date> colFecn;

    @FXML
    private TableColumn<Datos_persoEntity, String> colSexo;

    @FXML
    private TableColumn<Datos_persoEntity, String> colTele;

    @FXML
    private TableColumn<Datos_persoEntity, String> colDire;

    @FXML
    private TableColumn<Datos_persoEntity, String> colEmai;

    @FXML
    public void handleClick(ActionEvent e) throws SQLException {
        if (e.getSource() == btnAgregar) {
            bAdd = true;
            bEdt = false;
            desHabilBtn(true);
            clearTxtFlds();
        }else if (e.getSource() == btnCancelar) {
            bAdd = false;
            bEdt = false;
            desHabilBtn(false);
            clearTxtFlds();
        }else if (e.getSource() == btnEditar) {
            bEdt = true;
            bAdd = false;
            desHabilBtn(true);
        }else if (e.getSource() == btnEliminar) {
            if ( bAdd || bEdt) {
                return;
            }
            eliminaDtos();
            desHabilBtn(false);
            clearTxtFlds();
            bAdd = false;
            bEdt = false;
        }else if (e.getSource() == btnGuardar) {
            guardaDtos();
            desHabilBtn(false);
            clearTxtFlds();
            bAdd = false;
            bEdt = false;
        }else if (e.getSource() == btnAnte) {
            if (iIndx > 0) {
                iIndx--;
            }
            selectTV();
        }else if (e.getSource() == btnPrim) {
            iIndx=0;
            selectTV();
        }else if (e.getSource() == btnSigu) {
            if (iIndx < PrsoList.size()-1 ) {
                iIndx++;
            }
            selectTV();
        }else if (e.getSource() == btnUlti) {
            iIndx = PrsoList.size()-1;
            selectTV();
        }else if (e.getSource() == btnSalir) {
            Boolean Resp = ConfirmBox.display("Verifique su respuesta","Realmente desea salir");
            if (Resp == true) {
                System.exit(0);
            }
        }
    }
    private void selectTV() {
        tvDatosPerso.requestFocus();
        tvDatosPerso.getSelectionModel().select(iIndx);
        tvDatosPerso.getFocusModel().focus(iIndx);
        lblReg.setText("Registro: "+(iIndx+1)+" de "+PrsoList.size());
        LlenaTF();
    }
    private void showDatos() throws SQLException {
        PrsoList = datos_persoModel.getDatos_perso();
        colCodi.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, Integer>("id"));
        colCedu.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("cedula"));
        colNomb.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("nombre"));
        colApel.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("apellido"));
        colFecn.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, Date>("fecnac"));
        colSexo.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("sexo"));
        colTele.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("telefono"));
        colDire.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("direccion"));
        colEmai.setCellValueFactory(new PropertyValueFactory<Datos_persoEntity, String>("email"));
        tvDatosPerso.setItems(PrsoList);
    }
    private void desHabilBtn(Boolean bVal) {
        btnAgregar.setDisable(bVal);
        btnGuardar.setDisable(!bVal);
        btnCancelar.setDisable(!bVal);
        btnEliminar.setDisable(bVal);
        btnEditar.setDisable(bVal);
        btnPrim.setDisable(bVal);
        btnSigu.setDisable(bVal);
        btnAnte.setDisable(bVal);
        btnUlti.setDisable(bVal);
        btnSalir.setDisable(bVal);

        tfCodi.setDisable(bVal);
        tfApel.setDisable(!bVal);
        tfCedu.setDisable(!bVal);
        tfDire.setDisable(!bVal);
        tfEmai.setDisable(!bVal);
        tfNomb.setDisable(!bVal);
        tfTele.setDisable(!bVal);
        dpFecn.setDisable(!bVal);

        optF.setDisable(!bVal);
        optM.setDisable(!bVal);
    }
    private void eliminaDtos() throws SQLException {
        Boolean Resp = ConfirmBox.display("Verifique su respuesta","Realmente desea eliminar este registro");
        Integer iCodi = Integer.valueOf(tfCodi.getText());
        if (Resp == true && iCodi > 0) {
            datos_persoModel.deleteRecord(iCodi);
            showDatos();
        }
    }
    private void guardaDtos() throws SQLException {
        String sCedu = tfCedu.getText();
        String sNomb = tfNomb.getText();
        String sApel = tfApel.getText();
        Date dFecn = Date.valueOf(dpFecn.getValue());
        String sTele = tfTele.getText();
        String sDire = tfDire.getText();
        String sEmai = tfEmai.getText();
        if (bAdd) {
            datos_persoModel.insertRecord(sCedu, sNomb, sApel, sSexo.toLowerCase(Locale.ROOT), dFecn, sTele, sDire, sEmai);
        }else if (bEdt) {
            Integer iCodi = Integer.valueOf(tfCodi.getText());
            datos_persoModel.updateRecord(iCodi, sCedu, sNomb, sApel, sSexo.toLowerCase(Locale.ROOT), dFecn, sTele, sDire, sEmai);
        }
        clearTxtFlds();
        showDatos();
    }
    private void clearTxtFlds() {
        tfCodi.setText("");
        tfCedu.setText("");
        tfNomb.setText("");
        tfApel.setText("");
        dpFecn.getEditor().clear();
        //If you want to clear the value and the textfield, use :
        //datePicker.setValue(null);
        tfTele.setText("");
        tfDire.setText("");
        tfEmai.setText("");
    }

    @FXML
    void handleMouseAction(MouseEvent event) {
        LlenaTF();
    }
    private void LlenaTF() {
        Datos_persoEntity dtsPers = tvDatosPerso.getSelectionModel().getSelectedItem();
        tfCodi.setText(String.valueOf(dtsPers.getId()));
        tfCedu.setText(dtsPers.getCedula());
        tfNomb.setText(dtsPers.getNombre());
        tfApel.setText(dtsPers.getApellido());
        String sSxo = dtsPers.getSexo();
        if (sSxo == "m") {
            optM.setSelected(true);
        }else if (sSxo == "f") {
            optF.setSelected(true);
        }
        dpFecn.setValue(dtsPers.getFecnac().toLocalDate());
        tfTele.setText(dtsPers.getTelefono());
        tfDire.setText(dtsPers.getDireccion());
        tfEmai.setText(dtsPers.getEmail());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desHabilBtn(false);
        gSexo.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldToggle, Toggle newToggle)
            {
                sSexo = ((RadioButton)newToggle).getText();
            }
        });

        try {
            showDatos();
            selectTV();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
