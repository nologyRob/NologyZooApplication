package com.company;

import java.util.Scanner;

abstract public class Commands {
    private final Scanner scanner;
    private final String[] commands;
    private final String name;
    private final Zoo zoo;
    private CommandNames nextCommands;

    public Commands(String[] commands, String name, Zoo zoo) {
        this.scanner = new Scanner(System.in);
        this.nextCommands = CommandNames.Exit;
        this.commands = commands;
        this.name = name;
        this.zoo = zoo;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public String getName() {
        return name;
    }

    public CommandNames getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(CommandNames nextCommands) {
        this.nextCommands = nextCommands;
    }

    public int getIntegerInput() {
        boolean isGettingInput = true;
        int input = 0;

        while (isGettingInput) {
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int userInput = scanner.nextInt();

                if (userInput > 0 && userInput <= commands.length) {
                    input = userInput;
                    isGettingInput = false;
                } else {
                    printMessage("Enter a number between 1 - " + commands.length);
                }

            } else {
                printMessage("Unable to understand input, try again");
                scanner.nextLine();
            }
        }

        return input;
    }

    // SHOW YOU CAN CALL METHODS IN OTHER METHODS
    protected void printMessage(String message) {
        System.out.println(message);
    }

    // LOOPING
    protected void printIndexedCommands() {
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + ":" + commands[i]);
        }
    }

    // METHOD OVERLOADING +
    protected void printIndexedCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + ":" + commands[i]);
        }
    }


    protected String getStringInput() {
        // VALIDATE LIKE ^^ ABOVE USING STRING METHODS?
        String value = scanner.next();
        return value;
    }

    // NO IMPLEMENTATION
    public abstract void printCommands();

    public abstract void runCommands();
}
