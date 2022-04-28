package com.company.commands;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract public class Commands {
    protected final String name;
    private final Scanner scanner;
    private final String[] commands;
    protected CommandTypes nextCommands;

    public Commands(String[] commands, String name) {
        this.scanner = new Scanner(System.in);
        this.nextCommands = CommandTypes.Exit;
        this.commands = commands;
        this.name = name;
    }

    // GETTERS & SETTERS
    public CommandTypes getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(CommandTypes nextCommands) {
        this.nextCommands = nextCommands;
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }

    // SHOW YOU CAN CALL METHODS IN OTHER METHODS
    protected void printGreeting() {
        printMessage("Welcome to the " + name + " commands.");
    }

    protected int getIntegerInput(int limit) {
        boolean isActive = true;
        int input = 0;

        while (isActive) {
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int userInput = scanner.nextInt();

                if (userInput > 0 && userInput <= limit) {
                    input = userInput;
                    isActive = false;
                } else {
                    printMessage("Enter a number between 1 - " + limit);
                }

            } else {
                printMessage("Unable to understand input, try again");
                scanner.nextLine();
            }
        }
        // NEED THIS TO STOP IT SKIPPING WHEN YOU USE THE GET STRING INPUT
        scanner.nextLine();
        return input;
    }

    protected int getIntegerInput() {
        return getIntegerInput(commands.length);
    }

    // METHOD OVERLOADING + LOOPING
    protected void printIndexedCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + ":" + commands[i]);
        }
    }

    protected void printIndexedCommands() {
        printIndexedCommands(commands);
    }

    protected void printIndexedCommands(List<String> commands) {
        for (int i = 0; i < commands.size(); i++) {
            printMessage((i + 1) + ":" + commands.get(i));
        }
    }

    protected String getStringInput(String message) {

        printMessage(message);

        boolean isActive = true;

        String input = "";

        while (isActive) {
            String userInput = scanner.nextLine();

            String userInputClean = userInput.trim().toLowerCase(Locale.ROOT);

            if (!userInputClean.equals("")) {
                input = userInputClean;
                isActive = false;
            } else {
                printMessage("Unable to understand input, try again");
            }

        }

        return input;
    }

    // NO IMPLEMENTATION
    public abstract void printCommands();

    public abstract void runCommands();
}
