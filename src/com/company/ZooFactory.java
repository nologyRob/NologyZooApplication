package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS

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

    private static void populateAnimals(Zoo zoo) throws FileNotFoundException {
        DataLoader csvReader = new CSVDataLoader();

        Map<String, Integer> animalCountDictionary = csvReader.createDictionary("animal-count.csv");

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


