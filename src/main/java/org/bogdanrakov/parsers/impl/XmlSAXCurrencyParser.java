package org.bogdanrakov.parsers.impl;

import org.bogdanrakov.Currency;
import org.bogdanrakov.parsers.CurrencyParser;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XmlSAXCurrencyParser implements CurrencyParser {

    public List<Currency> parseCurrency() {
        List<Currency> result = new ArrayList<Currency>();

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXCurrencyHandler handler = new SAXCurrencyHandler();
            saxParser.parse(new InputSource(
                    new URL(XML_CURRENCY_NBU_URL).openStream()), handler);
            result = handler.getCurrencyList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
