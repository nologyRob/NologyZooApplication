package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS

import com.company.animals.*;

import java.io.FileNotFoundException;
import java.util.Map;

public class ZooFactory {

    public static Animal createAnimal(AnimalTypes animal, int index) {
        switch (animal) {
            case LION:
                return new Lion(AnimalTypes.LION.toString() + index);
            case LLAMA:
                return new Llama(AnimalTypes.LLAMA.toString() + index);
            default:
                return new Crocodile(AnimalTypes.CROCODILE.toString() + index);
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
                Animal lion = createAnimal(AnimalTypes.LION, lionCount);
                zoo.addAnimal(lion);
                lionCount--;
            }

            if (llamaCount > 0) {
                Animal llama = createAnimal(AnimalTypes.LLAMA, llamaCount);
                zoo.addAnimal(llama);
                llamaCount--;
            }

            if (crocodileCount > 0) {
                Animal crocodile = createAnimal(AnimalTypes.CROCODILE, crocodileCount);
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


