package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCountries {

    public String getCountryName(String index) throws IOException, ParseException {

        String query = "https://restcountries.eu/rest/v2/alpha/" + index;


        HttpURLConnection connection = null;

        connection = (HttpURLConnection) new URL(query).openConnection();

        connection.setRequestMethod("GET");

        connection.connect();

        StringBuilder countries = new StringBuilder();
        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) ;
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        while ((line = in.readLine()) != null) {
            countries.append(line);
            countries.append("\n");
        }

        JSONParser parse = new JSONParser();
        JSONObject obj_countries = (JSONObject) parse.parse(countries.toString());
        JSONObject obj_name = (JSONObject) parse.parse(countries.toString());
        JSONObject obj_capital = (JSONObject) parse.parse(countries.toString());
        JSONObject obj_lang = (JSONObject) parse.parse(countries.toString());

        return obj_countries.get("borders").toString() + ("\n") + obj_name.get("name").toString()+ ("\n")+ obj_capital.get("capital").toString() + ("\n")
                + obj_lang.get("languages");

    }
}