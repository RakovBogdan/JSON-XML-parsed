package org.bogdanrakov.parsers;

import org.bogdanrakov.Currency;

import java.util.List;

public interface CurrencyParser {

    String XML_CURRENCY_NBU_URL = "http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";
    String JSON_CURRENCY_NBU_URL = "http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    List<Currency> parseCurrency();
}
