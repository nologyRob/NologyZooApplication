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
            } else if (userSelection == 2) {
                printMessage("View by species");
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
