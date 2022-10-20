package com.solution.kotenko.api_dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PartOfSpeech {

    String apiURL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    String wordAppendix = "make";

    public HttpURLConnection getHttpRequest() {
        try {
            URL url = new URL(apiURL+wordAppendix);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return httpURLConnection;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> readDataFromApiToArrayList(HttpURLConnection httpURLConnection) {

        if (httpURLConnection == null) {
            return null;
        }

        //read data from API to ArrayList
        ArrayList<String> data = new ArrayList<>();
        StringBuilder result = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            String inputLine;
            result = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //delete square brackets []
        assert result != null;
        result = new StringBuilder(result.toString().replace("[", ""));
        result = new StringBuilder(result.toString().replace("]", ""));

        StringTokenizer st = new StringTokenizer(result.toString(), "}");
        while (st.hasMoreTokens()) {
            data.add(st.nextToken());
        }

        //return the curly braces to their place (needs for getting correct JSON format)
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).replace(",{", "{"));
            data.set(i, data.get(i) + "}");
        }

        return data;
    }

}
