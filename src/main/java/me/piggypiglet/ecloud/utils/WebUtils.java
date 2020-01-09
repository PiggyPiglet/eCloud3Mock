package me.piggypiglet.ecloud.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class WebUtils {
    public static String request(String link) throws Exception {
        return request(link, new HashMap<>());
    }

    public static String request(String link, Map<String, String> headers) throws Exception {
        final HttpURLConnection connection = (HttpURLConnection) new URL(link).openConnection();
        headers.forEach(connection::addRequestProperty);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder builder = new StringBuilder();

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            builder.append(inputLine);

        in.close();
        return builder.toString();
    }
}
