package com.company;

public class AnimalCommands extends Commands {

    // TODO
    // VIEW ALL ANIMALS
    // VIEW BY SPECIES
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

        printIndexedCommands(getZoo().getSpecies());

        boolean isActive = true;

        while (isActive) {
            int userSelection = getIntegerInput();

            if (userSelection == 1) {

            } else if (userSelection == 2) {

            } else if (userSelection == 3) {

            } else {

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
            } else if (userSelection == 4) {
                printMessage("Visit random animal");
            } else {
                setNextCommands(CommandNames.Visitor);
                isActive = false;
            }

        }
    }
}
