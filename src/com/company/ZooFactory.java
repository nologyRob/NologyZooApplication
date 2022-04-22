package com.company;

public class ZooFactory {

    private static Animal createAnimal(animalTypes animal, int index) {
        if (animalTypes.Lion.equals(animal)) {
            return new Lion("lion" + index);
        } else if (animalTypes.Llama.equals(animal)) {
            return new Llama("llama" + index);
        } else {
            return new Crocodile("crocodile" + index);
        }
    }


    public static Zoo populateZoo(Zoo zoo) {

        for (int i = 0; i < 10; i++) {
            Animal lion = ZooFactory.createAnimal(animalTypes.Lion, i);
            Animal llama = ZooFactory.createAnimal(animalTypes.Llama, i);
            Animal crocodile = ZooFactory.createAnimal(animalTypes.Crocodile, i);

            zoo.addAnimal(lion);
            zoo.addAnimal(llama);
            zoo.addAnimal(crocodile);
        }

        return zoo;
    }

    private static enum animalTypes {
        Lion, Llama, Crocodile
    }

}
