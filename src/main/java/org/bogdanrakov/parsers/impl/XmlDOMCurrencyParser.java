package org.bogdanrakov.parsers.impl;

import org.bogdanrakov.Currency;
import org.bogdanrakov.parsers.CurrencyParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XmlDOMCurrencyParser implements CurrencyParser {

    public List<Currency> parseCurrency() {
        List<Currency> result = new ArrayList<Currency>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(new URL("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange").openStream());
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("currency");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Currency currency = new Currency(element.getAttribute("r030"),
                            element.getAttribute("txt"),
                            Double.parseDouble(element.getAttribute("rate")),
                            element.getAttribute("cc"),
                            element.getAttribute("exchangedate"));
                    result.add(currency);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
