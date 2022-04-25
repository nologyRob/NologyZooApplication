package com.company;

// TODO
// PREPOPULATE VISITORS + ZOO-KEEPERS
// RANDOMISE THE ANIMALS

public class ZooFactory {

    private static Animal createAnimal(AnimalTypes animal, int index) {
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
        zoo.addSpecies(AnimalTypes.Lion.toString());
        zoo.addSpecies(AnimalTypes.Llama.toString());
        zoo.addSpecies(AnimalTypes.Crocodile.toString());

        for (int i = 0; i < 10; i++) {
            Animal lion = createAnimal(AnimalTypes.Lion, i);
            Animal llama = createAnimal(AnimalTypes.Llama, i);
            Animal crocodile = createAnimal(AnimalTypes.Crocodile, i);

            zoo.addAnimal(lion);
            zoo.addAnimal(llama);
            zoo.addAnimal(crocodile);
        }

    }


}
