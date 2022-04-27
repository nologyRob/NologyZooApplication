package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS
// RANDOMISE THE ANIMALS

import com.company.animals.*;

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

    private static void populateAnimalTypes(Zoo zoo) {
        for (AnimalTypes animalType : AnimalTypes.values()) {
            zoo.addAnimalTypes(animalType.toString());
        }
    }

    public static void populateZoo(Zoo zoo) throws FileNotFoundException {
        Map<String, Integer> animalCountDictionary = CSVReader.createDictionaryFromCSV("animal-count.csv");

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

        populateAnimalTypes(zoo);
    }

}


