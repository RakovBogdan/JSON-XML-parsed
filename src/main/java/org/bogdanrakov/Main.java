package org.bogdanrakov;

import org.bogdanrakov.parsers.JSONParser;

public class Main {

    public static void main(String[] args) {
        String sURL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        JSONParser parser = new JSONParser(sURL);
        System.out.printf(parser.getParsedFieldAsString("Долар США"));
    }
}
