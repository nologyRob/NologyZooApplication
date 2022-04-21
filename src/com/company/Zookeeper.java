package com.company;

import java.util.Locale;

public class Zookeeper extends User {
    public Zookeeper(String name, boolean isStaff) {
        super(name, isStaff=true);
    }

    private void cleanPen(Pen pen) {
        System.out.println("Cleanliness was " + pen.getCleanliness());
        pen.setCleanliness();
        System.out.println("Cleanliness is now " + pen.getCleanliness());
    }

    private void removeAnimal(Animal animal, Zoo zoo) {
        System.out.println("You have chosen to remove the animal " + animal);
        zoo.removeAnimal(animal);
        System.out.println("Animal " + animal + " is now removed");
    }

    private void addAnimal(String name, String type, Zoo zoo) {
        switch (type.toLowerCase(Locale.ROOT)){
            case "lion":
                // animal creator here?
                break;
            case "zebra":
                // animal creator here?
                break;
            case "tiger":
                // animal creator here?
                break;
        }

        System.out.println("You have chosen to add the animal type " + type + " and the name of ");
        zoo.addAnimal(animal);
        System.out.println("Animal " + animal + " is now added");
    }

    private void healAnimal(Animal animal, Zoo zoo) {
        System.out.println("You have chosen to improve the health of the animal " + animal);
        zoo.getAnimals().remove(animal);
        System.out.println("You have removed the animal " + animal);
    }
}
