package com.company;

public class AnimalCommands extends Commands {

    public AnimalCommands(Zoo zoo) {
        super(new String[]{"Do something", "Visit Animal", "Edit Information", "Exit"}, "Animal", zoo);
    }

    @Override
    public void printCommands() {
        printMessage("Welcome to the Animal commands");
        printIndexedCommands();
    }

    @Override
    public void runCommands() {
        printCommands();
    }
}
