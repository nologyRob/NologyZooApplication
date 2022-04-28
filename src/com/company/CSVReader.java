package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader implements Readable {


    public Map<String, Integer> createDictionaryFromCSV(String fileName) throws FileNotFoundException {
        Map<String, Integer> csvDictionary = new HashMap<>();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            boolean isFirstRow = true;
            String[] keys = new String[0];

            while (true) {
                String line = fileReader.readLine();
                if (line == null) break;

                String[] values = line.split(",");

                if (isFirstRow) {
                    keys = values;
                    isFirstRow = false;
                } else {
                    for (int i = 0; i < values.length; i++) {
                        csvDictionary.put(keys[i], Integer.parseInt(values[i]));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return csvDictionary;
    }

    @Override
    public List<String[]> createListFromCSV(String fileName) throws FileNotFoundException {
        List<String[]> csvList = new ArrayList<>();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            boolean isFirstRow = true;

            while (true) {
                String line = fileReader.readLine();

                if (line == null) break;

                if (isFirstRow) {
                    isFirstRow = false;
                } else {
                    csvList.add(line.split(","));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return csvList;
    }
}
