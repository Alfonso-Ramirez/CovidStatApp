package com.example.assignmentjava2.covidstatsapp.model;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiClient {

    private static final String API_URL = "https://api.api-ninjas.com/v1/covid19?country=";
    private static final String API_KEY = "3Z71M9DG8aLARIbTmk3kTQ==AKmLofSAXAuQwPay"; // Replace with your actual API key

    public static String getCovidStats(String country) throws Exception {
        URL url = new URL(API_URL + country);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key", API_KEY); // Set the API key

        InputStream responseStream = connection.getInputStream();

        // Convert InputStream to String
        try (Scanner scanner = new Scanner(responseStream)) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
