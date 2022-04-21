package com.company;

import java.util.Scanner;

abstract public class Commands {
    private final Scanner scanner;
    private final String[] commands;

    public Commands(String[] commands) {
        this.scanner = new Scanner(System.in);
        this.commands = commands;
    }

    public String[] getCommands() {
        return commands;
    }

    // SHOW YOU CAN CALL METHODS IN OTHER METHODS
    public void printMessage(String message) {
        System.out.println(message);
    }

    // LOOPING
    public void printIndexedOptions() {
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + ":" + commands[i]);
        }
    }

    // METHOD OVERLOADING +
    public void printIndexedOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            printMessage((i + 1) + ":" + options[i]);
        }
    }

    public int getIntegerInput(int limit) {
        boolean isGettingInput = true;
        int input = 0;

        while (isGettingInput) {
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int userInput = scanner.nextInt();

                if (userInput > 0 && userInput <= limit) {
                    input = userInput;
                    isGettingInput = false;
                } else {
                    printMessage("Enter a number between 1 - " + limit);
                }

            } else {
                printMessage("Unable to understand input, try again");
                scanner.nextLine();
            }
        }

        return input;
    }

    public String getStringInput() {
        // VALIDATE LIKE ^^ ABOVE
        String value = scanner.next();
        return value;
    }

    // NO IMPLEMENTATION
    public abstract void printCommands();

    public abstract int getUserSelection();

    public abstract int runCommands();
}
