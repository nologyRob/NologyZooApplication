package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CSVReader implements Readable {
    public static Map<String, Integer> createDictionaryFromCSV(String fileName) throws FileNotFoundException {
        Map<String, Integer> animalCountDictionary = new HashMap<>();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            boolean isFirstRow = true;
            String[] keys = new String[0];

            while (true) {
                line = fileReader.readLine();

                if (line == null) break;

                String[] values = line.split(",");

                if (isFirstRow) {
                    keys = values;
                    isFirstRow = false;
                } else {
                    for (int i = 0; i < values.length; i++) {
                        animalCountDictionary.put(keys[i], Integer.parseInt(values[i]));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return animalCountDictionary;
    }
}
