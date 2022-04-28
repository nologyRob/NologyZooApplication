package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS

import com.company.animals.*;
import com.company.users.User;
import com.company.users.UserTypes;
import com.company.users.Visitor;
import com.company.users.Zookeeper;

import java.io.FileNotFoundException;
import java.util.Map;

public class ZooFactory {

    public static Animal createAnimal(AnimalTypes animal, int index) {
        switch (animal) {
            case Lion:
                return new Lion(AnimalTypes.Lion.toString() + index);
            case Llama:
                return new Llama(AnimalTypes.Llama.toString() + index);
            default:
                return new Crocodile(AnimalTypes.Crocodile.toString() + index);
        }
    }

    public static User createUser(String userType, String name, String password) {
        if (userType.equals(UserTypes.Zookeeper.toString())) {
            return new Zookeeper(name, password);
        } else {
            return new Visitor(name, password);
        }
    }

    private static void populateAnimalTypes(Zoo zoo) {
        for (AnimalTypes animalType : AnimalTypes.values()) {
            zoo.addAnimalTypes(animalType.toString());
        }
    }

    private static void populateAnimals(Zoo zoo) throws FileNotFoundException {
        Readable csvReader = new CSVReader();

        Map<String, Integer> animalCountDictionary = csvReader.createDictionaryFromCSV("animal-count.csv");

        int lionCount = animalCountDictionary.get("lion");
        int llamaCount = animalCountDictionary.get("llama");
        int crocodileCount = animalCountDictionary.get("crocodile");

        while (lionCount > 0 || llamaCount > 0 || crocodileCount > 0) {
            if (lionCount > 0) {
                Animal lion = createAnimal(AnimalTypes.Lion, lionCount);
                zoo.addAnimal(lion);
                lionCount--;
            }

            if (llamaCount > 0) {
                Animal llama = createAnimal(AnimalTypes.Llama, llamaCount);
                zoo.addAnimal(llama);
                llamaCount--;
            }

            if (crocodileCount > 0) {
                Animal crocodile = createAnimal(AnimalTypes.Crocodile, crocodileCount);
                zoo.addAnimal(crocodile);
                crocodileCount--;
            }

        }
    }

    public static void populateZoo(Zoo zoo) throws FileNotFoundException {

        populateAnimals(zoo);
        populateAnimalTypes(zoo);
    }

}


