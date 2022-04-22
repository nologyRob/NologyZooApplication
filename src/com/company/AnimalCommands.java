package com.company;

public class AnimalCommands extends Commands {

    public AnimalCommands() {
        super(new String[]{"Do something", "Visit Animal", "Edit Information", "Exit"});
    }

    @Override
    public void printCommands() {

    }

    @Override
    public int getUserSelection() {
        return 0;
    }

    @Override
    public int runCommands() {
        return 0;
    }
}
