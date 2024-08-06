package com.example.assignmentjava2.covidstatsapp.model;

import com.example.assignmentjava2.covidstatsapp.view.CovidStat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class CovidStatsService {

    public static List<CovidStat> parseCovidStats(String jsonResponse) {
        Gson gson = new Gson();
        Type covidStatListType = new TypeToken<List<CovidStat>>(){}.getType();
        return gson.fromJson(jsonResponse, covidStatListType);
    }
}
