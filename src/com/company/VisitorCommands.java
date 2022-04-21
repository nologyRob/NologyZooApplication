package com.company;

import java.util.ArrayList;

public class VisitorCommands extends Commands {

    private final boolean isStaff;

    public VisitorCommands() {
        super(new String[]{"Display animals", "Display pens", "Exit"});
        this.isStaff = false;
    }

    public <T extends Animal> void printAnimals(ArrayList<T> animals) {
        for (T animal : animals) {
            printMessage(animal.getName());
        }
    }

    @Override
    public void printOptions() {
        printMessage("Select an option:");
        printIndexedOptions();
        printMessage("Enter option:");
    }

    @Override
    public int getUserSelection() {
        printOptions();
        return getIntegerInput();
    }


}
