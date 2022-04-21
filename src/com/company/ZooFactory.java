package com.company;

public class ZooFactory {

    private static Animal animalFactory(animalTypes animal, int index) {
        if (animalTypes.Lion.equals(animal)) {
            return new Lion("lion" + index);
        } else if (animalTypes.Zebra.equals(animal)) {
            return new Zebra("zebra" + index);
        } else {
            return new Crocodile("crocodile" + index);
        }
    }

    public static Zoo populateZoo(Zoo zoo) {

        // RANDOM NUMBER OF ANIMALS?
        Pen<Animal> lionPen = new Pen<>("lion");
        Pen<Animal> zebraPen = new Pen<>("zebra");
        Pen<Animal> crocodilePen = new Pen<>("crocodile");

        for (int i = 0; i < 10; i++) {
            Animal lion = ZooFactory.animalFactory(animalTypes.Lion, i);
            Animal zebra = ZooFactory.animalFactory(animalTypes.Zebra, i);
            Animal crocodile = ZooFactory.animalFactory(animalTypes.Crocodile, i);

            zoo.addAnimal(lion);
            lionPen.addAnimalToPen(lion);

            zoo.addAnimal(zebra);
            zebraPen.addAnimalToPen(lion);

            zoo.addAnimal(crocodile);
            crocodilePen.addAnimalToPen(lion);
        }

        zoo.addPen(lionPen);
        zoo.addPen(zebraPen);
        zoo.addPen(crocodilePen);

        return zoo;
    }

    private static enum animalTypes {
        Lion, Zebra, Crocodile
    }

}
