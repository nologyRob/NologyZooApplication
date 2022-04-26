package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS
// RANDOMISE THE ANIMALS

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

    public static void populateZoo(Zoo zoo) {

        for (int i = 0; i < 10; i++) {
            Animal lion = createAnimal(AnimalTypes.Lion, i);
            Animal llama = createAnimal(AnimalTypes.Llama, i);
            Animal crocodile = createAnimal(AnimalTypes.Crocodile, i);

            zoo.addAnimal(lion);
            zoo.addAnimal(llama);
            zoo.addAnimal(crocodile);
        }

        populateAnimalTypes(zoo);
    }

}
