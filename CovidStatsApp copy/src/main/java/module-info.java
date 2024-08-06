module com.example.assignmentjava2.covidstatsapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires javafx.base;
    requires com.google.gson;

    opens com.example.assignmentjava2.covidstatsapp to javafx.fxml, com.google.gson;
    exports com.example.assignmentjava2.covidstatsapp;
    exports com.example.assignmentjava2.covidstatsapp.controller;
    opens com.example.assignmentjava2.covidstatsapp.controller to com.google.gson, javafx.fxml;
    exports com.example.assignmentjava2.covidstatsapp.view;
    opens com.example.assignmentjava2.covidstatsapp.view to com.google.gson, javafx.fxml;
    exports com.example.assignmentjava2.covidstatsapp.model;
    opens com.example.assignmentjava2.covidstatsapp.model to com.google.gson, javafx.fxml;
}