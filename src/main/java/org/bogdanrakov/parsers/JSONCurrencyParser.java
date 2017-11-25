package org.bogdanrakov.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bogdanrakov.Currency;

import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONCurrencyParser {

    public List<Currency> parseCurrency() {
        String jsonToParse = null;
        try {
            URLConnection connection =  new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            jsonToParse = scanner.next();
        } catch (Exception e ) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Type currenciesListType = new TypeToken<ArrayList<Currency>>() {
        }.getType();

        return gson.fromJson(jsonToParse, currenciesListType);
    }
}
