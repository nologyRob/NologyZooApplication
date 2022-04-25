package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS
// RANDOMISE THE ANIMALS

public class ZooFactory {

    private static Animal createAnimal(animalTypes animal, int index) {
        switch (animal) {
            case Lion:
                return new Lion("lion" + index);
            case Llama:
                return new Llama("llama" + index);
            default:
                return new Crocodile("crocodile" + index);
        }
    }


    public static void populateZoo(Zoo zoo) {
        zoo.addSpecies(animalTypes.Lion.toString());
        zoo.addSpecies(animalTypes.Llama.toString());
        zoo.addSpecies(animalTypes.Crocodile.toString());

        for (int i = 0; i < 10; i++) {
            Animal lion = createAnimal(animalTypes.Lion, i);
            Animal llama = createAnimal(animalTypes.Llama, i);
            Animal crocodile = createAnimal(animalTypes.Crocodile, i);

            zoo.addAnimal(lion);
            zoo.addAnimal(llama);
            zoo.addAnimal(crocodile);
        }

    }

    private enum animalTypes {
        Lion, Llama, Crocodile
    }

}
