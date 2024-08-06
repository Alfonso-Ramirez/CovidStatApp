package com.example.assignmentjava2.covidstatsapp.controller;

import com.example.assignmentjava2.covidstatsapp.*;
import com.example.assignmentjava2.covidstatsapp.model.ApiClient;
import com.example.assignmentjava2.covidstatsapp.model.CovidStatsService;
import com.example.assignmentjava2.covidstatsapp.view.CovidStat;
import com.example.assignmentjava2.covidstatsapp.view.DailyCaseData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.util.List;

public class MainController {

    @FXML
    private TextField countryInput;

    @FXML
    private ListView<String> countryList;

    @FXML
    private Button detailsButton;

    @FXML
    public void handleGetStats(ActionEvent event) {
        String country = countryInput.getText();
        if (country == null || country.isEmpty()) {
            countryList.getItems().clear();
            countryList.getItems().add("Please enter a valid country name.");
            return;
        }

        try {
            String response = ApiClient.getCovidStats(country);
            List<CovidStat> stats = CovidStatsService.parseCovidStats(response);
            updateUI(stats);
        } catch (Exception e) {
            e.printStackTrace();
            countryList.getItems().clear();
            countryList.getItems().add("Failed to fetch data. Please try again.");
        }
    }

    private void updateUI(List<CovidStat> stats) {
        countryList.getItems().clear();
        if (stats.isEmpty()) {
            countryList.getItems().add("No data found for the specified country.");
            return;
        }

        for (CovidStat stat : stats) {
            DailyCaseData latestData = stat.getLatestCaseData(); // Get the latest daily case data
            String latestDate = stat.getLatestDate(); // Get the latest date

            countryList.getItems().add("Country: " + stat.getCountry() +
                    ", Region: " + stat.getRegion() +
                    ", Date: " + latestDate +
                    ", Total Cases: " + latestData.getTotal() +
                    ", New Cases: " + latestData.getNewCases());
        }
    }

    @FXML
    public void handleGetDetails(ActionEvent event) {
        String selectedItem = countryList.getSelectionModel().getSelectedItem();
        if (selectedItem == null || selectedItem.isEmpty()) {
            return; // No item selected, do nothing
        }

        // Extract country and region from selected item text
        // Assuming the format is "Country: [Country], Region: [Region], ..."

        // Example extraction logic, adjust based on actual format
        String[] parts = selectedItem.split(", ");
        String country = parts[0].replace("Country: ", "");
        String region = parts[1].replace("Region: ", "");

        try {
            String response = ApiClient.getCovidStats(country);
            List<CovidStat> stats = CovidStatsService.parseCovidStats(response);
            CovidStat selectedStat = stats.stream()
                    .filter(stat -> stat.getRegion().equals(region))
                    .findFirst()
                    .orElse(null);

            if (selectedStat != null) {
                MainApp.showDetailsView(selectedStat);
            } else {
                // Handle case where no matching CovidStat is found
                System.out.println("No details found for the selected region.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
