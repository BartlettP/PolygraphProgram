package edu.au.cpsc.module7;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PolygraphErrorWindow {
@FXML
private Button okButton;
    public static void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(PolygraphErrorWindow.class.getResource("polygraph-error-window.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("ERROR!");
        scene.getStylesheets().add(PolygraphErrorWindow.class.getResource("style/error.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void closeWindowAction() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
