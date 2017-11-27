package org.bogdanrakov;

import org.bogdanrakov.parsers.CurrencyParser;
import org.bogdanrakov.parsers.impl.XmlDOMCurrencyParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CurrencyParser parser = new XmlDOMCurrencyParser();
        List<Currency> currencyList = parser.parseCurrency();
        System.out.println(currencyList);
    }
}
