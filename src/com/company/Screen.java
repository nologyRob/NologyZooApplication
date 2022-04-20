package com.company;

import java.util.Scanner;

abstract public class Screen {
    private Scanner scanner;
    private String[] options;

    public Screen(String[] options) {
        this.scanner = new Scanner(System.in);
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    // SHOW YOU CAN CALL METHODS IN OTHER METHODS
    public void printMessage(String message) {
        System.out.println(message);
    }

    // LOOPING
    public void printIndexedOptions() {
        for (int i = 0; i < options.length; i++) {
            printMessage((i + 1) + ":" + options[i]);
        }
    }

    // METHOD OVERLOADING +
    public void printIndexedOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            printMessage((i + 1) + ":" + options[i]);
        }
    }

    public int getIntegerInput() {
        boolean isGettingInput = true;
        int input = 0;

        while (isGettingInput) {
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int userInput = scanner.nextInt();

                if (userInput > 0 && userInput <= options.length) {
                    input = userInput;
                    isGettingInput = false;
                } else {
                    printMessage("Enter a number between 1 - " + options.length);
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
    public abstract void printOptions();
    public abstract int getUserSelection();
}