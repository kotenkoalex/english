package com.solution.kotenko.prepared_data_utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TakeData {

    public static int getRatingMax(HashMap<String, Integer[]> vocabulary) {
        final int[] ratingMax = {0};
        vocabulary.forEach((key, value) -> {
            if (value[0] > ratingMax[0]) {
                ratingMax[0] = value[0];
            }
        });
        return ratingMax[0];
    }

    public static int getLengthMax(HashMap<String, Integer[]> vocabulary) {
        final int[] lengthMax = {1};
        vocabulary.forEach((key, value) -> {
            if (value[1] > lengthMax[0]) {
                lengthMax[0] = value[1];
            }
        });
        return lengthMax[0];
    }

    public HashMap<String, Integer[]> countRating(HashMap<String, Integer[]> vocabularyQuantity) {
        int quantityMax = TakeData.getRatingMax(vocabularyQuantity);

        //distribution of quantity 1-(55%), 2-(13%), 3-4-(13%), 5-20-(14%), >20-(5%)
        HashMap<String, Integer[]> result = new HashMap<>(vocabularyQuantity);
        for (Map.Entry<String, Integer[]> word : result.entrySet()) {
            if (word.getValue()[0] <= 1) {
                word.setValue(new Integer[]{1, word.getValue()[1]});
            } else if (word.getValue()[0] <= 2) {
                word.setValue(new Integer[]{2, word.getValue()[1]});
            } else if (word.getValue()[0] <= 4) {
                word.setValue(new Integer[]{3, word.getValue()[1]});
            } else if (word.getValue()[0] <= 20) {
                word.setValue(new Integer[]{4, word.getValue()[1]});
            } else {
                word.setValue(new Integer[]{5, word.getValue()[1]});
            }
        }
        return result;
    }

    public HashMap<String, Integer[]> countQuantity(ArrayList<String> vocabulary) {
        int rating = 0;
        HashMap<String, Integer[]> result = new HashMap<>();
        String word;
        for (int i = 0; i < vocabulary.size(); i++) {
            word = vocabulary.get(i);
            for (String vocabularyElement : vocabulary) {
                if (word.equals(vocabularyElement)) {
                    rating++;
                }
            }
            result.put(word, new Integer[]{rating, word.length()});
            rating = 0;
        }
        return result;
    }

    public ArrayList<String> takeDataStrict(HashMap<String, Integer[]> vocabulary, int rating, int length) {

        int ratingMax = TakeData.getRatingMax(vocabulary);
        int lengthMax = TakeData.getLengthMax(vocabulary);
        if (rating > ratingMax) {
            rating = ratingMax;
        }
        if (length > lengthMax) {
            length = lengthMax;
        }

        ArrayList<String> result = new ArrayList<>();
        int finalRating = rating;
        int finalLength = length;
        vocabulary.forEach((key, value) -> {
            if (value[0] == finalRating && value[1] == finalLength) {
                result.add(key);
            }
        });
        return result;
    }

    public ArrayList<String> takeDataFrom(HashMap<String, Integer[]> vocabulary, int ratingFrom, int lengthFrom) {

        int ratingMax = TakeData.getRatingMax(vocabulary);
        int lengthMax = TakeData.getLengthMax(vocabulary);
        if (ratingFrom > ratingMax) {
            ratingFrom = ratingMax;
        }
        if (lengthFrom > lengthMax) {
            lengthFrom = lengthMax;
        }

        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer[]> entry : vocabulary.entrySet()) {
            String key = entry.getKey();
            Integer[] value = entry.getValue();
            if (value[0] >= ratingFrom && value[1] >= lengthFrom) {
                result.add(key);
            }
        }
        return result;
    }

    public ArrayList<String> takeDataFromTo(
            HashMap<String, Integer[]> vocabulary, int ratingFrom, int ratingTo, int lengthFrom, int lengthTo) {

        int ratingMax = TakeData.getRatingMax(vocabulary);
        int lengthMax = TakeData.getLengthMax(vocabulary);
        if (ratingTo > ratingMax) {
            ratingTo = ratingMax;
        }
        if (lengthTo > lengthMax) {
            lengthTo = lengthMax;
        }

        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer[]> entry : vocabulary.entrySet()) {
            String key = entry.getKey();
            Integer[] value = entry.getValue();
            if (value[0] >= ratingFrom && value[0] <= ratingTo && value[1] >= lengthFrom && value[1] <= lengthTo) {
                result.add(key);
            }
        }
        return result;
    }
}
