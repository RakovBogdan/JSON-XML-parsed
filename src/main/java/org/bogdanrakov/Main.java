package org.bogdanrakov;

import org.bogdanrakov.parsers.JSONCurrencyParser;
import org.bogdanrakov.parsers.XmlDOMCurrencyParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        JSONCurrencyParser parser = new JSONCurrencyParser();
        XmlDOMCurrencyParser parser = new XmlDOMCurrencyParser();
        List<Currency> currencyList = parser.parseCurrency();
        System.out.println(currencyList);
    }
}
