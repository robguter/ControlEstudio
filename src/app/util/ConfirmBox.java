package app.util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmBox {
    static boolean answer;
    public static boolean display(String Title, String Msj) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.setMinWidth(400);
        window.setMinHeight(250);

        Label oEtiq = new Label();
        oEtiq.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        oEtiq.setText(Msj);

        Button btnYes = new Button("Yes");
        btnYes.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        btnYes.setMinWidth(80);
        btnYes.setOnAction(e-> {
            answer = true;
            window.close();
        });

        Button btnNo = new Button("No");
        btnNo.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        btnNo.setMinWidth(80);
        btnNo.setOnAction(e-> {
            answer = false;
            window.close();
        });

        HBox layouth = new HBox(20);
        layouth.getChildren().addAll(btnYes,btnNo);
        layouth.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(oEtiq,layouth);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}