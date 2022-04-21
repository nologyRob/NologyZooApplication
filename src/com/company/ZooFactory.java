package com.company;

import java.util.Locale;

public class ZooFactory {

    private static Animal animalFactory(animalTypes animal, int index) {
        if (animalTypes.Lion.equals(animal)) {
            return new Lion("lion" + index);
        } else if (animalTypes.Llama.equals(animal)) {
            return new Llama("llama" + index);
        } else {
            return new Crocodile("crocodile" + index);
        }
    }

    public static Zoo populateZoo(Zoo zoo) {

        // RANDOM NUMBER OF ANIMALS?
        Pen<Animal> lionPen = new Pen<>("lion");
        Pen<Animal> llamaPen = new Pen<>("zebra");
        Pen<Animal> crocodilePen = new Pen<>("crocodile");

        for (int i = 0; i < 10; i++) {
            Animal lion = ZooFactory.animalFactory(animalTypes.Lion, i);
            Animal llama = ZooFactory.animalFactory(animalTypes.Llama, i);
            Animal crocodile = ZooFactory.animalFactory(animalTypes.Crocodile, i);

            zoo.addAnimal(lion);
            lionPen.addAnimalToPen(lion);

            zoo.addAnimal(llama);
            llamaPen.addAnimalToPen(lion);

            zoo.addAnimal(crocodile);
            crocodilePen.addAnimalToPen(lion);
        }

        zoo.addPen(lionPen);
        zoo.addPen(llamaPen);
        zoo.addPen(crocodilePen);

        return zoo;
    }

    private static enum animalTypes {
        Lion, Llama, Crocodile
    }

}
