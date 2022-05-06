package com.company.commands;

import com.company.Zoo;
import com.company.animals.AnimalTypes;
import com.company.users.Auth;

import java.util.List;

public class ZookeeperCommands extends Commands {
    private final Zoo zoo;
    private final Auth authentication;

    public ZookeeperCommands(Zoo zoo, Auth authentication) {
        super(new String[]{"See List of Hungry Animals", "Feed Animals", "Add Animal", "Remove Animal", "Search", "Sort animals by popularity", "Log off"}, "Zookeeper");
        this.zoo = zoo;
        this.authentication = authentication;
    }

    private void printHungryAnimals() {
        printMessage("The following animals are hungry and need feeding\n");
        printMessage(zoo.getHungryAnimalInformation());
    }

    private void feedHungryAnimals() {
        zoo.feedHungryAnimals();
        printHungryAnimals();
    }

    private void addAnimal() {
        List<String> animalTypes = zoo.getAnimalTypes();
        printIndexedCommands(animalTypes);
        int userInput = getIntegerInput(animalTypes.size());

        if (userInput == 1) {
            zoo.createAnimal(AnimalTypes.LION);
        } else if (userInput == 2) {
            zoo.createAnimal(AnimalTypes.LLAMA);
        } else {
            zoo.createAnimal(AnimalTypes.CROCODILE);
        }
    }

    private void removeAnimal() {
        String userInput = getStringInput("Type the ID of the animal you would like to remove");
        boolean isRemoved = zoo.removeAnimal(userInput);
        if (isRemoved) {
            printMessage("Successfully removed animal");
        } else {
            printMessage("Unable to remove animal");
        }
    }

    private void searchZoo() {
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
        printGreeting();
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
                printHungryAnimals();
            } else if (userSelection == 2) {
                feedHungryAnimals();
            } else if (userSelection == 3) {
                addAnimal();
            } else if (userSelection == 4) {
                removeAnimal();
            } else if (userSelection == 5) {
                searchZoo();
            } else if (userSelection == 6) {
                printPopularAnimals();
            } else {
                setNextCommands(CommandTypes.LOGIN);
                authentication.logOut();
                isActive = false;
            }
        }
    }

    private void printPopularAnimals() {
        printMessage(zoo.getPopularAnimalInformation());
    }


}
