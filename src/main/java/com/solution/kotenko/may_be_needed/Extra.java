package com.solution.kotenko.may_be_needed;

import com.solution.kotenko.file_utils.MyFileReader;
import com.solution.kotenko.file_utils.MyFileWriter;
import com.solution.kotenko.prepared_data_utils.TextProcessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//works with files
public class Extra {
    private static ArrayList<String> makeOneListFromAllDuplicateFile(ArrayList<File> vocabularyDuplicateList) {
        ArrayList<String> allWords = new ArrayList<>();
        ArrayList<String> vocabulary;
        MyFileReader myFileReader = new MyFileReader();
        for (File file : vocabularyDuplicateList) {
            vocabulary = myFileReader.readFileToList(file.getPath());
            allWords.addAll(vocabulary);
        }
        return allWords;
    }

    private static void makeOutputUniqueVocabulary(ArrayList<File> filePatches, String pathOutputDir, String suffix) {
        MyFileReader myFileReader = new MyFileReader();
        MyFileWriter myFileWriter = new MyFileWriter();
        ArrayList<String> lines;
        List<String> collect;
        for (File filePatch : filePatches) {
            lines = myFileReader.readFileToList(filePatch.getPath());
            collect = lines.stream().distinct().collect(Collectors.toList());
            myFileWriter.writeToFile((ArrayList<String>) collect, makePathOut(pathOutputDir, suffix, filePatch));
        }
    }

    private static void makeOutputDuplicatedVocabulary(ArrayList<File> filePatches, String pathOutputDir, String suffix) {
        MyFileReader myFileReader = new MyFileReader();
        TextProcessor textProcessor = new TextProcessor();
        MyFileWriter myFileWriter = new MyFileWriter();
        for (File filePatch : filePatches) {
            ArrayList<String> lines = myFileReader.readFileToList(filePatch.getPath());
            ArrayList<String> vocabulary = textProcessor.splitStringToSeparateWords(lines);
            myFileWriter.writeToFile(vocabulary, makePathOut(pathOutputDir, suffix, filePatch));
        }
    }

    public static String makePathOut(String pathOutputDir, String newSuffix, File file) {
        return pathOutputDir + newSuffix + file.getName().substring(file.getName().indexOf('_') + 1);
    }
}
