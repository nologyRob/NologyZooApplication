package com.company.commands;

import com.company.Zoo;
import com.company.animals.AnimalTypes;

import java.util.List;

public class ZookeeperCommands extends Commands {
    private final Zoo zoo;

    public ZookeeperCommands(Zoo zoo) {
        super(new String[]{"See Zoo Overview", "See List of Hungry Animals", "Feed Animals", "Add Animal", "Remove Animal", "Search", "Log off"}, "Zookeeper");
        this.zoo = zoo;
    }

    private void printAllAnimals() {
        printMessage(zoo.getAllAnimalsInformation());
    }

    public void printHungryAnimals() {
        printMessage("The following animals are hungry and need feeding\n");
    }

    public void addAnimal() {
        List<String> animalTypes = zoo.getAnimalTypes();
        printIndexedCommands(animalTypes);
        int userInput = getIntegerInput(animalTypes.size());

        if (userInput == 1) {
            zoo.createAnimal(AnimalTypes.Lion);
        } else if (userInput == 2) {
            zoo.createAnimal(AnimalTypes.Llama);
        } else {
            zoo.createAnimal(AnimalTypes.Crocodile);
        }
    }

    public void removeAnimal() {
        String userInput = getStringInput("Type the ID of the animal you would like to remove");
        boolean isRemoved = zoo.removeAnimal(userInput);
        if (isRemoved) {
            printMessage("Successfully removed animal");
        } else {
            printMessage("Unable to remove animal");
        }
    }

    public void searchZoo() {
        String searchTerm = getStringInput("Enter search term below");

        List<String> searchResults = zoo.searchZoo(searchTerm);

        if (searchResults.size() > 0) {
            printMessage("Successfully found these matches:");
            for (String searchResult : searchResults) {
                printMessage(searchResult);
            }
        } else {
            printMessage("Unable to find any matches");
        }
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
                printAllAnimals();
            } else if (userSelection == 2) {
                printHungryAnimals();
            } else if (userSelection == 3) {
                // NEED TO DO SOMETHING ELSE
                System.out.println("DOING SOMETHING");
            } else if (userSelection == 4) {
                addAnimal();
            } else if (userSelection == 5) {
                removeAnimal();
            } else if (userSelection == 6) {
                searchZoo();
            } else {
                setNextCommands(CommandNames.Login);
                isActive = false;
            }
        }
    }


}
