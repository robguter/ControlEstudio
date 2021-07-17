package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class alumnosController implements Initializable {

    @FXML
    private TextField txtId, txtNombre, txtApellido;

    @FXML
    private Label lblReg;

    @FXML
    private RadioButton optM, optF;

    @FXML
    private ToggleGroup Sexo;

    @FXML
    private DatePicker dtpFechaing, dtpFechanac;

    @FXML
    private ComboBox<?> cboCarrera, cboCentro;

    @FXML
    private Button btnAgregar, btnGuardar, btnEditar, btnCancelar,
            btnEliminar, btnSalir, btnPrim, btnAnte, btnSigu, btnUlti;

    @FXML
    private TableView<?> tvAlum;

    @FXML
    private TableColumn<?, ?> colNombre, colApellido, colFechanac,
            colSexo, colFechaing, colCarrera, colCentro;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
