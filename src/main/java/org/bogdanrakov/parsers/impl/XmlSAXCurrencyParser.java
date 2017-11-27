package org.bogdanrakov.parsers.impl;

import org.bogdanrakov.Currency;
import org.bogdanrakov.parsers.CurrencyParser;

import java.util.ArrayList;
import java.util.List;

public class XmlSAXCurrencyParser implements CurrencyParser {

    public List<Currency> parseCurrency() {
        List<Currency> result = new ArrayList<Currency>();


//        XMLReader myReader = XMLReaderFactory.createXMLReader();
//        myReader.setContentHandler(handler);
//        myReader.parse(new InputSource(new URL(url).openStream()));

        return result;
    }
}
