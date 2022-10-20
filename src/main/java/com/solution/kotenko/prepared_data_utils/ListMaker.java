package com.solution.kotenko.prepared_data_utils;

import com.solution.kotenko.file_utils.MyFileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListMaker {
    public static ArrayList<String> makeSentencesList(ArrayList<File> listOfPath) {
        ArrayList<String> allSentences = new ArrayList<>();
        ArrayList<String> oneFileSentences;
        MyFileReader myFileReader = new MyFileReader();
        for (File file : listOfPath) {
            oneFileSentences = myFileReader.readFileToList(file.getPath());
            allSentences.addAll(oneFileSentences);
        }
        return allSentences;
    }

    public static ArrayList<String> makeWordsList(ArrayList<String> sentencesList) {
        return new TextProcessor().splitStringToSeparateWords(sentencesList);
    }

    public static ArrayList<String> makeUniqueWordsList(ArrayList<String> wordsList) {
        return (ArrayList<String>) wordsList.stream().distinct().collect(Collectors.toList());
    }
}