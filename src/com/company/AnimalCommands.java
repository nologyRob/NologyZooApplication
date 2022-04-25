package com.company;

import java.util.ArrayList;

public class AnimalCommands extends Commands {

    // TODO
    // CLEAN UP -> VISITING ANIMALS
    // ZOO KEEPER???????

    public AnimalCommands(Zoo zoo) {
        super(new String[]{"View All Animals", "View By Species", "Visit Animal", "Visit Random Animal", "Go Back"}, "Animal", zoo);
    }

    private void printAllAnimals() {
        getZoo().getAllAnimalInformation().forEach(this::printMessage);
    }

    private void printSpecies() {
        printMessage("Select a species:");
        ArrayList<String> species = getZoo().getSpecies();

        printIndexedCommands(species);

        ArrayList<Animal> selectedSpecies;

        int userSelection = getIntegerInput(species.size());
        String message;

        if (userSelection == 1) {
            selectedSpecies = getZoo().getSpecies(AnimalTypes.Lion);
            message = "We have the following " + AnimalTypes.Lion + "s in the Zoo.";
        } else if (userSelection == 2) {
            selectedSpecies = getZoo().getSpecies(AnimalTypes.Llama);
            message = "We have the following " + AnimalTypes.Llama + "s in the Zoo.";
        } else {
            selectedSpecies = getZoo().getSpecies(AnimalTypes.Crocodile);
            message = "We have the following " + AnimalTypes.Crocodile + "s in the Zoo.";
        }

        printMessage(message);
        selectedSpecies.forEach(specie -> printMessage(specie.getInfo()));
    }

    // TODO
    // NEEDS WORK :S
    private void visitAnimal() {
        String animalId;
        printMessage("Enter the animal ID below:");
        animalId = getStringInput();

        if (getZoo().hasAnimal(animalId)) {
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
            printIndexedCommands(new String[]{"Pet", "Give token", "Go back"});

            int userSelection = getIntegerInput(3);

            if (userSelection == 1) {
                getZoo().petAnimal(animalId);
            } else if (userSelection == 2) {
                getZoo().giveToken(animalId);
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
                printMessage("View by species");
                printSpecies();
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
