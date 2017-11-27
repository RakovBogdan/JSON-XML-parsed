package org.bogdanrakov;

import org.bogdanrakov.parsers.CurrencyParser;
import org.bogdanrakov.parsers.impl.JSONCurrencyParser;
import org.bogdanrakov.parsers.impl.XmlDOMCurrencyParser;
import org.bogdanrakov.parsers.impl.XmlSAXCurrencyParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CurrencyParser parser;
        List<Currency> currencyList;

        parser = new JSONCurrencyParser();
        currencyList = parser.parseCurrency();
        System.out.println(currencyList);

        parser = new XmlDOMCurrencyParser();
        currencyList = parser.parseCurrency();
        System.out.println(currencyList);

        parser = new XmlSAXCurrencyParser();
        currencyList = parser.parseCurrency();
        System.out.println(currencyList);
    }
}
