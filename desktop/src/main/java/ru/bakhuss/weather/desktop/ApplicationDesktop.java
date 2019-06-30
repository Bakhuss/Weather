package ru.bakhuss.weather.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.bakhuss.weather.desktop.controller.MainController;

import java.io.IOException;

public class ApplicationDesktop extends Application {
    private Stage primaryStage;

    public ApplicationDesktop() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        method();
    }

    public void method() {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(ApplicationDesktop.class.getResource("/view/fxml/main.fxml"));
            AnchorPane mainView = (AnchorPane) loader.load();

            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.show();

            MainController controller = loader.getController();
            controller.setApplicationDesktop(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
