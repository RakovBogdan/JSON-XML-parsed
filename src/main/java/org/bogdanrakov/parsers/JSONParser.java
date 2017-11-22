package org.bogdanrakov.parsers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONParser {

    private String urlString;
    private URL url;
    private JsonObject rootObject;

    public JSONParser(String urlString) {
        this.urlString = urlString;

        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection request;

        try {
            request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            rootObject = root.getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getParsedFieldAsString(String field) {
        return rootObject.get(field).getAsString();
    }

}
