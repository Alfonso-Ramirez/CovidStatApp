package com.example.assignmentjava2.covidstatsapp.view;

import com.google.gson.annotations.SerializedName;

public class DailyCaseData {

    private int total;

    @SerializedName("new")
    private int newCases;

    // Getters and setters

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }
}
