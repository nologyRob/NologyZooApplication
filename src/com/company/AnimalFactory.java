package com.company;

public class AnimalFactory {

    public static Zoo populateZoo(Zoo zoo) {

        Pen<Animal> lionPen = new Pen<>("lion");

        for (int i = 0; i < 10; i++) {
            Lion lion = new Lion("Lion" + i);
            zoo.addAnimal(lion);
            lionPen.addAnimalToPen(lion);
        }

        zoo.addPen(lionPen);

        return zoo;
    }
}
