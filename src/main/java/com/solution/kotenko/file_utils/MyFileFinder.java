package com.solution.kotenko.file_utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MyFileFinder {

    public ArrayList<File> filePathStorage(String dirPath){
        ArrayList<File> filePathStorage = new ArrayList<>();
        File file = new File(dirPath);
        Collections.addAll(filePathStorage, Objects.requireNonNull(file.listFiles()));
        return filePathStorage;
    }
}