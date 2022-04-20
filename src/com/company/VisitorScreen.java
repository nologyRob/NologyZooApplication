package com.company;

import java.util.ArrayList;

public class VisitorScreen extends Screen {

    private final boolean isStaff;

    public VisitorScreen(String[] options, boolean isStaff) {
        super(options);
        this.isStaff = isStaff;
    }

    public void printAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
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
