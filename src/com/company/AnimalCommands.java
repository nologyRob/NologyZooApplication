package com.company;

import java.util.ArrayList;

public class AnimalCommands extends Commands {

    // TODO
    // CLEAN UP -> VISITING ANIMALS
    // ZOO KEEPER???????

    public AnimalCommands(Zoo zoo) {
        super(new String[]{"View All Animals", "View By Animal Type", "Visit Animal", "Visit Random Animal", "Go Back"}, "Animal", zoo);
    }

    private void printAllAnimals() {
        printMessage(getZoo().getAllAnimalsInformation());
    }

    private void printAnimalsByType() {
        printMessage("Select a Type of Animal:");
        ArrayList<String> animalTypes = getZoo().getAnimalTypes();

        printIndexedCommands(animalTypes);

        ArrayList<Animal> selectedAnimalsByType;

        int userSelection = getIntegerInput(animalTypes.size());

        String message;

        if (userSelection == 1) {
            selectedAnimalsByType = getZoo().getAnimalsByType(AnimalTypes.Lion);
            message = "We have the following " + AnimalTypes.Lion + "s in the Zoo.";
        } else if (userSelection == 2) {
            selectedAnimalsByType = getZoo().getAnimalsByType(AnimalTypes.Llama);
            message = "We have the following " + AnimalTypes.Llama + "s in the Zoo.";
        } else {
            selectedAnimalsByType = getZoo().getAnimalsByType(AnimalTypes.Crocodile);
            message = "We have the following " + AnimalTypes.Crocodile + "s in the Zoo.";
        }

        printMessage(message);
        selectedAnimalsByType.forEach(animal -> printMessage(animal.getInformation()));
    }

    // TODO
    // NEEDS WORK :S
    private void visitAnimal() {
        String animalId;
        animalId = getStringInput("Enter the animal ID below:");

        if (getZoo().animalExists(animalId)) {
            interactWithAnimal(animalId);
        } else {
            printMessage("Animal not found...");
        }
    }

    private void visitRandomAnimal() {
        interactWithAnimal(getZoo().getRandomAnimalId());
    }

    private void interactWithAnimal(String animalId) {

        boolean isActive = true;

        while (isActive) {

            printMessage(getZoo().getAnimalInformation(animalId));

            printIndexedCommands(new String[]{"Pet", "Give token", "Go back"});

            int userSelection = getIntegerInput(3);

            if (userSelection == 1) {
                boolean hasPet = getZoo().petAnimal(animalId);
                printMessage(hasPet ? "Successful petting" : "Unsuccessful petting");
            } else if (userSelection == 2) {
                boolean hasSpentToken = getZoo().spendAnimalToken(animalId);
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
                setNextCommands(CommandNames.Visitor);
                isActive = false;
            }

        }
    }
}
