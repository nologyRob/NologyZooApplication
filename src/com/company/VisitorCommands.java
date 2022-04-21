package com.company;

import java.util.ArrayList;

public class VisitorCommands extends Commands {

    private final ArrayList<Animal> animals;
    private boolean isActive;

    public VisitorCommands(ArrayList<Animal> animals) {
        super(new String[]{"See animal information", "Visit Pen", "Edit Information", "Exit"});
        this.isActive = true;
        this.animals = animals;
    }

    public void printAnimals() {
        for (Animal animal : animals) {
            printMessage(animal.getInfo());
        }
    }

    @Override
    public void printCommands() {
        printMessage("Select an option:");
        printIndexedOptions();
        printMessage("Enter option:");
    }

    @Override
    public int getUserSelection() {
        return getIntegerInput(getCommands().length);
    }

    @Override
    public int runCommands() {
        int userSelection = -1;

        while (isActive) {
            printCommands();

            userSelection = getUserSelection();

            if (userSelection == 1) {
                printAnimals();
            } else {
                isActive = false;
            }
        }

        return userSelection;
    }


}
