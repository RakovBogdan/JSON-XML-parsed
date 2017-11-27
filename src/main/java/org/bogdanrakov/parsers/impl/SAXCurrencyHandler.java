package org.bogdanrakov.parsers.impl;

import org.bogdanrakov.Currency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXCurrencyHandler extends DefaultHandler {

    private List<Currency> currencyList = new ArrayList<Currency>();
    private Currency currency;

    private boolean bR030 = false;
    private boolean bTxt = false;
    private boolean bRate = false;
    private boolean bCc = false;
    private boolean bExchangeDate = false;

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bR030) {
            currency.setR030(new String(ch, start, length));
            bR030 = false;
        } else if (bTxt) {
            currency.setTxt(new String(ch, start, length));
            bTxt = false;
        } else if (bRate) {
            currency.setRate(Double.parseDouble(new String(ch, start, length)));
            bRate = false;
        } else if (bCc) {
            currency.setCc(new String(ch, start, length));
            bCc = false;
        } else if (bExchangeDate) {
            currency.setExchangedate(new String(ch, start, length));
            bExchangeDate = false;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException{
        if (qName.equalsIgnoreCase("currency")) {
            currency = new Currency();
        }
        else if (qName.equalsIgnoreCase("r030")) {
            bR030 = true;
        } else if (qName.equalsIgnoreCase("txt")) {
            bTxt = true;
        } else if (qName.equalsIgnoreCase("rate")) {
            bRate = true;
        } else if (qName.equalsIgnoreCase("cc")) {
            bCc = true;
        } else if (qName.equalsIgnoreCase("exchangedate")) {
            bExchangeDate = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("currency")) {
            currencyList.add(currency);
        }
    }

    List<Currency> getCurrencyList() {
        return currencyList;
    }
}
