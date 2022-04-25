package com.company;

import java.util.Locale;

public class ZookeeperCommands extends Commands {

    public ZookeeperCommands(Zoo zoo) {
        super(new String[]{"See Zoo Overview", "See List of Hungry Animals", "See List of Unhappy Animals", "Add Animal", "Remove Animal", "Log off", "Exit"}, "Zookeeper", zoo);
    }

    public void printAnimals() {
        for (Animal animal : getZoo().getAnimals()) {
            printMessage(animal.getInfo());
        }
    }

    public void printHungryAnimals() {
        System.out.println("The following animals are hungry and need feeding\n");
        for (Animal animal : getZoo().getAnimals()) {
            if(animal.getHunger()<50)
                printMessage(animal.getInfo());
        }
    }

    public void printUnhappyAnimals() {
        System.out.println("The following animals are severely unhappy and need attention\n");
        for (Animal animal : getZoo().getAnimals()) {
            if(animal.getHappiness()<20)
                printMessage(animal.getInfo());
        }
    }

    public String getAnimalType() {
        System.out.println("What type of animal are you looking to add?");
        return getStringInput();
    }


    public Animal getAnimalById() {
        Animal desiredAnimal = null;
        printMessage("Type the ID of the animal you would like to remove");
        String id = getStringInput();
        for (Animal animal : getZoo().getAnimals()) {
            if(animal.getId().equals(id)){
                desiredAnimal = animal;
                System.out.println("Animal found");
            }
        }
        return desiredAnimal;
    }


    @Override
    public void printCommands() {
        printMessage("Welcome to the " + getName() + " commands.");
        printMessage("Select an option:");
        printIndexedCommands();
        printMessage("Enter option:");
    }


    @Override
    public void runCommands() {
        boolean isActive = true;

        while (isActive) {
            printCommands();

            int userSelection = getIntegerInput();

            if (userSelection == 1) {
                printAnimals();
            } else if (userSelection == 2) {
                printHungryAnimals();
            } else if (userSelection == 3) {
                printUnhappyAnimals();
            } else if (userSelection == 4) {
                getZoo().addAnimal(getAnimalType());
            } else if (userSelection == 5) {
                getZoo().removeAnimal(getAnimalById());
            }else {
                setNextCommands(CommandNames.Exit);
                isActive = false;
            }
        }
    }


}
