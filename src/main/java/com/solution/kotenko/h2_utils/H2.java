package com.solution.kotenko.h2_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class H2 {

    private Connection openH2Connection() {
        Connection connection = null;
        try {
            String URL = "jdbc:h2:~/friends";
            String USER_NAME = "friends";
            String PASSWORD = "friends";
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertDateToH2(int word_id, String word_name, int word_frequency, int word_length,
                               int sentence_id, int season_id, int part_of_speech_id) {

        Connection connection = openH2Connection();
        String sql_insert =
                "INSERT INTO WORD " +
                        "(WORD_ID, WORD_NAME, WORD_FREQUENCY, WORD_LENGTH, SENTENCE_ID, SEASON_ID, PART_OF_SPEECH_ID)" +
                        "VALUES (" + word_id + ", '" + word_name + "', " + word_frequency + ", " + word_length + ", " +
                        sentence_id + ", " + season_id + ", " + part_of_speech_id + ")";

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql_insert);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCollectionToH2(ArrayList<String> list) {
        int word_id;
        String word_name;
        int word_frequency;
        int word_length;
        int sentence_id = 0;
        int season_id = 0;
        int part_of_speech_id = 0;

        String[] split;
        for (int i = 0; i < list.size(); i++) {
            split = list.get(i).split(",");
            word_id = i + 1;
            word_name = split[0].trim();
            word_frequency = Integer.parseInt(split[1].trim());
            word_length = Integer.parseInt(split[2].trim());
            insertDateToH2(word_id, word_name, word_frequency, word_length, sentence_id, season_id, part_of_speech_id);
        }
    }
}