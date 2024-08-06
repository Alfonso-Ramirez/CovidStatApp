package com.example.assignmentjava2.covidstatsapp;

import com.example.assignmentjava2.covidstatsapp.controller.DetailsController;
import com.example.assignmentjava2.covidstatsapp.view.CovidStat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        primaryStage.setTitle("COVID-19 Statistics");

        // Load the icon
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/assignmentjava2/covidstatsapp/covid19_16x16.png")));
        primaryStage.getIcons().addAll(
                new Image(getClass().getResourceAsStream("/com/example/assignmentjava2/covidstatsapp/covid19_16x16.png")),
                new Image(getClass().getResourceAsStream("/com/example/assignmentjava2/covidstatsapp/covid19_32x32.png")),
                new Image(getClass().getResourceAsStream("/com/example/assignmentjava2/covidstatsapp/covid19_64x64.png"))
        );
        showMainView();
    }

    public static void showMainView() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/example/assignmentjava2/covidstatsapp/MainView.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(MainApp.class.getResource("/com/example/assignmentjava2/covidstatsapp/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showDetailsView(CovidStat covidStat) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/example/assignmentjava2/covidstatsapp/DetailsView.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(MainApp.class.getResource("/com/example/assignmentjava2/covidstatsapp/style.css").toExternalForm());
            DetailsController controller = loader.getController();
            controller.setCovidStat(covidStat);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
