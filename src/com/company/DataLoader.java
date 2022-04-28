package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


public interface DataLoader {
    Map<String, Integer> createDictionary(String fileName) throws FileNotFoundException;

    List<String[]> createUsers(String fileName) throws FileNotFoundException;
}
