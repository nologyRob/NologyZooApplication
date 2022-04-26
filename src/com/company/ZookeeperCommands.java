package com.company;

import java.util.ArrayList;

public class ZookeeperCommands extends Commands {

    public ZookeeperCommands(Zoo zoo) {
        super(new String[]{"See Zoo Overview", "See List of Hungry Animals", "Feed Animals", "Add Animal", "Remove Animal", "Search", "Log off"}, "Zookeeper", zoo);
    }

    private void printAllAnimals() {
        printMessage(getZoo().getAnimalsOverview());
    }

    public void printHungryAnimals() {
        printMessage("The following animals are hungry and need feeding\n");
    }

    public void addAnimal() {
        ArrayList<String> animalTypes = getZoo().getAnimalTypes();
        printIndexedCommands(animalTypes);
        int userInput = getIntegerInput(animalTypes.size());

        if (userInput == 1) {
            getZoo().addAnimal(AnimalTypes.Lion);
        } else if (userInput == 2) {
            getZoo().addAnimal(AnimalTypes.Llama);
        } else {
            getZoo().addAnimal(AnimalTypes.Crocodile);
        }
    }

    public void removeAnimal() {
        printMessage("Type the ID of the animal you would like to remove");
        String userInput = getStringInput();
        boolean isRemoved = getZoo().removeAnimal(userInput);
        if (isRemoved) {
            printMessage("Successfully removed animal");
        } else {
            printMessage("Unable to remove animal");
        }
    }

    public void searchZoo() {
        printMessage("Enter search term below");
        String searchTerm = getStringInput();

        ArrayList<String> searchResults = getZoo().searchZoo(searchTerm);

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
