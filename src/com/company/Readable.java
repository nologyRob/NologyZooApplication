package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface Readable {
    public Map<String, Integer> createDictionaryFromCSV(String fileName) throws FileNotFoundException;

    public List<String[]> createListFromCSV(String fileName) throws FileNotFoundException;
}
