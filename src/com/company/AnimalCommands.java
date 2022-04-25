package com.company;

import java.util.ArrayList;

public class AnimalCommands extends Commands {

    // TODO
    // VISIT ANIMAL + VISIT RANDOM ANIMAL - SIMILAR FUNCTIONALITY
    // - PET ANIMAL
    // - RATE / GIVE TOKEN


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
            } else if (userSelection == 4) {
                printMessage("Visit random animal");
            } else {
                setNextCommands(CommandNames.Visitor);
                isActive = false;
            }

        }
    }
}
