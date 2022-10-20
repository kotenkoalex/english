package com.solution.kotenko.file_utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyFileWriter {

    public void writeToFile(ArrayList<String> list, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            for (String line : list) {
                fw.write(line + "\n");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void writeToFile(HashMap<String, Integer[]> stringHashMap, String path) {
        try (FileWriter fw = new FileWriter(path)) {
            for (Map.Entry<String, Integer[]> line : stringHashMap.entrySet()) {
                fw.write(line.getKey() + ", " + line.getValue()[0] + ", " + line.getValue()[1] + "\n");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
