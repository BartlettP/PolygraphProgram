package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PolygraphScheduleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PolygraphScheduleApplication.class.getResource("polygraph-schedule-app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 630);
        stage.setTitle("Polygraph Schedule Application");
        scene.getStylesheets().add(getClass().getResource("style/main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
