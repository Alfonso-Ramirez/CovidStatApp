package com.example.assignmentjava2.covidstatsapp.view;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class CovidStat {

    private String country;
    private String region;

    @SerializedName("cases")
    private Map<String, DailyCaseData> cases; // This will map each date to a DailyCaseData object

    // Getters and setters

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Map<String, DailyCaseData> getCases() {
        return cases;
    }

    public void setCases(Map<String, DailyCaseData> cases) {
        this.cases = cases;
    }

    // Helper method to get the most recent case data
    public DailyCaseData getLatestCaseData() {
        // Reduce the entries to get the most recent date entry
        return cases.entrySet().stream().reduce((first, second) -> second).get().getValue();
    }

    // Helper method to get the most recent date string
    public String getLatestDate() {
        // Reduce the entries to get the most recent date key
        return cases.entrySet().stream().reduce((first, second) -> second).get().getKey();
    }
}
