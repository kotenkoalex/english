package com.solution.kotenko;

import com.solution.kotenko.file_utils.MyFileReader;
import com.solution.kotenko.h2_utils.H2;
import com.solution.kotenko.service.References;

import java.util.ArrayList;

public class Main implements References {

    public static void main(String[] args) {

//        ArrayList<File> listOfPath = new MyFileFinder().filePathStorage(PATH_INPUT_DIR);
//        ArrayList<String> sentencesList = ListMaker.makeSentencesList(listOfPath);
//        ArrayList<String> wordsList = ListMaker.makeWordsList(sentencesList);
//        ArrayList<String> uniqueWordsList = ListMaker.makeUniqueWordsList(wordsList);
//
//        TakeData takeData = new TakeData();
//        HashMap<String, Integer[]> stringHashMap = takeData.countQuantity(wordsList);
//
//        MyFileWriter myFileWriter = new MyFileWriter();
//        myFileWriter.writeToFile(stringHashMap, PATH_OUT);

        MyFileReader myFileReader = new MyFileReader();
        ArrayList<String> arrayList = myFileReader.readFileToList(PATH_OUT);

        H2 h2 = new H2();
        h2.addCollectionToH2(arrayList);
    }
}