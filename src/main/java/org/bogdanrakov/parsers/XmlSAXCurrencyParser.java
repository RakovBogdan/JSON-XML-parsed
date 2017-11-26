package org.bogdanrakov.parsers;

import org.bogdanrakov.Currency;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XmlSAXCurrencyParser {

    public List<Currency> parseCurrency() {
        List<Currency> result = new ArrayList<Currency>();


//        XMLReader myReader = XMLReaderFactory.createXMLReader();
//        myReader.setContentHandler(handler);
//        myReader.parse(new InputSource(new URL(url).openStream()));

        return result;
    }
}
