package app;

import app.model.oconnect;
import app.util.AlertBox;
import app.util.ConfirmBox;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("calculator.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("vistas/Main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1200, 800));

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            CloseWindow();
        });

        primaryStage.show();
        //Connection oConn = oconnect.Connect();
    }

    private void CloseWindow() {
        String sTit = "Confirme su respuesta";
        String sMsj = "Realmente desea salir?";
        boolean Resp = ConfirmBox.display(sTit,sMsj);
        if (Resp) {
            System.exit(0);
        }
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
