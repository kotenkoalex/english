package com.solution.kotenko.prepared_data_utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

    private String cleanLine(String line) {
        Pattern pattern = Pattern.compile("[A-Za-z' ]+");
        Matcher matcher = pattern.matcher(line.toLowerCase());
        StringBuilder result = new StringBuilder();
        while (matcher.find()){
            result.append(matcher.group());
        }
        return result.toString();
    }

    public ArrayList<String> splitStringToSeparateWords(ArrayList<String> lines) {
        ArrayList<String> cleanedLines = new ArrayList<>();
        ArrayList<String> vocabulary = new ArrayList<>();

        //clean forbiddenSymbols
        for (int i = 0; i < lines.size(); i++) {
            cleanedLines.add(i, cleanLine(lines.get(i)));
        }

        //split list of lines to list of
        StringTokenizer st;
        for (String line : cleanedLines) {
            st = new StringTokenizer(line, " ");
            while (st.hasMoreElements()) {
                vocabulary.add(st.nextToken());
            }
        }
        return vocabulary;
    }
}