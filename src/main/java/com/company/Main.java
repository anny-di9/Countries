package com.company;

import org.json.simple.parser.ParseException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        GetCountries gc = new GetCountries();
        System.out.println(gc.getCountryName("pol"));

    }
}

