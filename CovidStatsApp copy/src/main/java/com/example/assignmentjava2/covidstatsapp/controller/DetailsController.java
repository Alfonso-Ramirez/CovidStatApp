package com.example.assignmentjava2.covidstatsapp.controller;

import com.example.assignmentjava2.covidstatsapp.view.CovidStat;
import com.example.assignmentjava2.covidstatsapp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailsController {

    @FXML
    private Label countryLabel;

    @FXML
    private Label regionLabel;

    @FXML
    private Label totalCasesLabel;

    private CovidStat covidStat;

    public void setCovidStat(CovidStat covidStat) {
        this.covidStat = covidStat;
        if (covidStat != null) {
            countryLabel.setText(covidStat.getCountry());
            regionLabel.setText(covidStat.getRegion());
            totalCasesLabel.setText(String.valueOf(covidStat.getLatestCaseData().getTotal()));
        }
    }

    @FXML
    private void handleBackToMain() {
        MainApp.showMainView();
    }
}
