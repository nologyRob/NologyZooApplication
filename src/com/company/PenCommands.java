package com.company;

import java.util.ArrayList;

public class PenCommands extends Commands {
    // SEEN PENS -> SELECTED PEN -> FEED ANIMAL, PET ANIMAL ....
    private final String[] subCommands;
    private final ArrayList<Pen<Animal>> pens;
    private final boolean visitingPen;
    private boolean isActive;

    public PenCommands(ArrayList<Pen<Animal>> pens) {
        super(new String[]{"See all pens", "Select Pen", "Back to Visitor menu"});
        this.subCommands = new String[]{"Feed Animal", "Exit"};
        this.isActive = true;
        this.pens = pens;
        this.visitingPen = false;
    }

    public void printPens() {
        for (int i = 0, pensSize = pens.size(); i < pensSize; i++) {
            Pen<Animal> pen = pens.get(i);
            printMessage(i + 1 + ":" + pen.getName());
        }
    }

    public void printSubCommands() {
        printIndexedOptions(subCommands);
    }

    @Override
    public void printCommands() {
        printIndexedOptions();
    }

    @Override
    public int getUserSelection() {
        return getIntegerInput(getCommands().length);
    }

    public int getUserSubSelection() {
        return getIntegerInput(subCommands.length);
    }

    public int getPenSelection() {
        return getIntegerInput(pens.size());
    }

    @Override
    public int runCommands() {
        while (isActive) {
            printCommands();
            int userSelection = getUserSelection();

            if (userSelection == 1) {
                printPens();
            } else if (userSelection == 2) {
                runSubCommands();
            } else {
                isActive = false;
            }
        }
        return 1;
    }

    private int runSubCommands() {
        printMessage("Select a Pen");
        int userChoice = getPenSelection();
        printSubCommands();
        // TODO
        // GET PEN
        // INTERACT WITH IT

        return -1;
    }
}
