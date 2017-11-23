package org.bogdanrakov;

import org.bogdanrakov.parsers.JSONParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String sURL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        JSONParser parser = new JSONParser();

        List<Currency> currencyList = parser.parseCurrency();
        System.out.println(currencyList);
    }
}
