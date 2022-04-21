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

    private void addAnimal(String name, String type, Zoo zoo, Pen pen) {
        System.out.println("You have chosen to add the animal type " + type + " and the name of " + name);
        switch (type.toLowerCase(Locale.ROOT)){
            case "lion":
                Lion lion = new Lion(name + zoo.getAnimals().size());
//                pen.addAnimalToPen(lion);
                break;
            case "zebra":
                Llama zebra = new Llama(name + zoo.getAnimals().size());
//                pen.addAnimalToPen(zebra);
                break;
            case "crocodile":
                Crocodile crocodile = new Crocodile(name + zoo.getAnimals().size());
//                pen.addAnimalToPen(crocodile);
                break;
        }
        System.out.println("Animal " + name + " is now added");
    }

    private void removeAnimal(String animalName, Zoo zoo) {
        System.out.println("You have chosen to improve the health of the animal " + animalName);
        zoo.getAnimals().forEach((animal) -> {
            if (animal.getName().equals(animalName)) {
                zoo.removeAnimal(animal);
            }
        });
    }
}
