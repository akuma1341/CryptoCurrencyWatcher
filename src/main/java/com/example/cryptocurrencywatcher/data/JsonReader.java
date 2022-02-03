package com.example.cryptocurrencywatcher.data;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(PricesUpdater.class);

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            if (cp != 93 && cp != 91)
                sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws JSONException {
        JSONObject json = null;
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
            return json;
        } catch (IOException e) {
            LOGGER.error("Error creating json object: " + e.getMessage());
        }
        return json;
    }
}
