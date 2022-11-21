package com.solution.kotenko.file_utils;

import com.solution.kotenko.service.Directory;
import com.solution.kotenko.service.References;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileCreator implements References {

    private ArrayList<String> filePathStorage;
    private String currentPath;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public String makeNewFile(String fileName, String fileExtension, Directory dir) {
        String pathToDir;
        String suffix;
        switch (dir) {
            case INPUT -> {
                pathToDir = PATH_INPUT_DIR;
                suffix = SUFFIX_INPUT;
            }
            case OUTPUT_DUPLICATE -> {
                pathToDir = PATH_OUTPUT_DUPLICATE_DIR;
                suffix = SUFFIX_DUPLICATE;
            }
            case OUTPUT_UNIQUE -> {
                pathToDir = PATH_OUTPUT_UNIQUE_DIR;
                suffix = SUFFIX_UNIQUE;
            }
            case OUTPUT -> {
                pathToDir = PATH_OUTPUT_DIR;
                suffix = SUFFIX_DEFAULT;
            }
            default -> {
                pathToDir = PATH_DEFAULT_DIR;
                suffix = SUFFIX_DEFAULT;
            }
        }

        File fileInput = new File(pathToDir + suffix + fileName + fileExtension);
        try {
            fileInput.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentPath = fileInput.getPath();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public ArrayList<String> makeNewFile(
            String fileName, String fileExtension, Directory dir, int season, int numberOfSeries) {
        filePathStorage = new ArrayList<>();
        String pathToDir;
        String suffix;
        switch (dir) {
            case INPUT -> {
                pathToDir = PATH_INPUT_DIR;
                suffix = SUFFIX_INPUT;
            }
            case OUTPUT_DUPLICATE -> {
                pathToDir = PATH_OUTPUT_DUPLICATE_DIR;
                suffix = SUFFIX_DUPLICATE;
            }
            case OUTPUT_UNIQUE -> {
                pathToDir = PATH_OUTPUT_UNIQUE_DIR;
                suffix = SUFFIX_UNIQUE;
            }
            default -> {
                pathToDir = PATH_DEFAULT_DIR;
                suffix = SUFFIX_DEFAULT;
            }
        }

        String seriesNumber;
        File file;
        for (int i = 1; i <= numberOfSeries; i++) {
            seriesNumber = "_" + season + "_" + i;
            file = new File(pathToDir + suffix + fileName + seriesNumber + fileExtension);
            try {
                file.createNewFile();
                filePathStorage.add(file.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePathStorage;
    }

    public ArrayList<String> getFilePathStorage() {
        return filePathStorage;
    }

    public String getCurrentPath() {
        return currentPath;
    }
}
