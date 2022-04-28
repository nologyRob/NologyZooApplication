package com.company.commands;

import com.company.Zoo;
import com.company.animals.AnimalTypes;

import java.util.List;

public class AnimalCommands extends Commands {
    private final Zoo zoo;

    public AnimalCommands(Zoo zoo) {
        super(new String[]{"View All Animals", "View By Animal Type", "Visit Animal", "Visit Random Animal", "Go Back"}, "Animal");
        this.zoo = zoo;
    }

    private void printAllAnimals() {
        printMessage(zoo.getAllAnimalsInformation());
    }

    private void printAnimalsByType() {
        printMessage("Select a Type of Animal:");
        List<String> animalTypes = zoo.getAnimalTypes();
        printIndexedCommands(animalTypes);

        String selectedAnimalsByType;

        int userSelection = getIntegerInput(animalTypes.size());

        String message;

        if (userSelection == 1) {
            selectedAnimalsByType = zoo.getAnimalInformationByType(AnimalTypes.Lion);
            message = "We have the following " + AnimalTypes.Lion + "s in the Zoo.";
        } else if (userSelection == 2) {
            selectedAnimalsByType = zoo.getAnimalInformationByType(AnimalTypes.Llama);
            message = "We have the following " + AnimalTypes.Llama + "s in the Zoo.";
        } else {
            selectedAnimalsByType = zoo.getAnimalInformationByType(AnimalTypes.Crocodile);
            message = "We have the following " + AnimalTypes.Crocodile + "s in the Zoo.";
        }

        printMessage(message);
        printMessage(selectedAnimalsByType);
    }

    private void visitAnimal() {
        String animalId;
        animalId = getStringInput("Enter the animal ID below:");

        if (zoo.hasAnimal(animalId)) {
            interactWithAnimal(animalId);
        } else {
            printMessage("Animal not found...");
        }
    }

    private void visitRandomAnimal() {
        interactWithAnimal(zoo.getRandomAnimalId());
    }

    private void interactWithAnimal(String animalId) {

        boolean isActive = true;

        while (isActive) {

            printMessage(zoo.getAnimalInformation(animalId));

            printIndexedCommands(new String[]{"Pet", "Give token", "Go back"});

            int userSelection = getIntegerInput(3);

            if (userSelection == 1) {
                boolean hasPet = zoo.petAnimal(animalId);
                printMessage(hasPet ? "Successful petting" : "Unsuccessful petting");
            } else if (userSelection == 2) {
                boolean hasSpentToken = zoo.spendAnimalToken(animalId);
                printMessage(hasSpentToken ? "Animal token spent" : "No tokens left to spend");
            } else {
                isActive = false;
            }

        }
    }

    @Override
    public void printCommands() {
        printMessage("Welcome to the Animal commands");
        printIndexedCommands();
    }

    @Override
    public void runCommands() {
        boolean isActive = true;

        while (isActive) {
            printCommands();

            int userSelection = getIntegerInput();

            if (userSelection == 1) {
                printMessage("View all animals");
                printAllAnimals();
            } else if (userSelection == 2) {
                printMessage("View by Animal type");
                printAnimalsByType();
            } else if (userSelection == 3) {
                printMessage("Visit animal");
                visitAnimal();
            } else if (userSelection == 4) {
                printMessage("Visit random animal");
                visitRandomAnimal();
            } else {
                setNextCommands(CommandTypes.Visitor);
                isActive = false;
            }

        }
    }
}
