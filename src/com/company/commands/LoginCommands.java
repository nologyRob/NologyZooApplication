package com.company.commands;


// TODO

import com.company.Zoo;
import com.company.users.Auth;

public class LoginCommands extends Commands {
    private final Zoo zoo;
    private Auth authentication = new Auth();

    public LoginCommands(Zoo zoo) {
        super(new String[]{"Create a new Visitor", "Login as Visitor", "Login as Zoo Keeper", "Exit"}, "login");
        this.zoo = zoo;
    }

    private void createVisitor() {
        String name = getStringInput("Enter Name below:");
        String password = getStringInput("Enter Password below:");
        authentication.createVisitor(name, password);
    }

    private boolean loginVisitor() {
        boolean isActive = true;
        boolean isLoggedIn = false;

        while (isActive) {
            String name = getStringInput("Enter Name below:");
            String password = getStringInput("Enter Password below:");
            isLoggedIn = authentication.logInVisitor(name, password);

            if (isLoggedIn) {
                isActive = false;
            } else {
                printMessage("Unable to authenticate");

                printIndexedCommands(new String[]{"Retry", "Go Back"});

                int userSelection = getIntegerInput();

                if (userSelection == 2) {
                    isActive = false;
                }
            }

        }
        return isLoggedIn;
    }

    private boolean loginZookeeper() {
        boolean isActive = true;
        boolean isLoggedIn = false;

        while (isActive) {
            String name = getStringInput("Enter Name below:");
            String password = getStringInput("Enter Password below:");
            isLoggedIn = authentication.logInZookeeper(name, password);

            if (isLoggedIn) {
                isActive = false;
            } else {
                printMessage("Unable to authenticate");

                printIndexedCommands(new String[]{"Retry", "Go Back"});

                int userSelection = getIntegerInput();

                if (userSelection == 2) {
                    isActive = false;
                }
            }

        }
        return isLoggedIn;
    }

    @Override
    public void printCommands() {
        printMessage("Welcome to the Zoo");
        printIndexedCommands();
        printMessage("Enter Selection Below:");
    }

    @Override
    public void runCommands() {
        boolean isActive = true;

        while (isActive) {
            printCommands();

            int userSelection = getIntegerInput();

            if (userSelection == 1) {
                createVisitor();
                setNextCommands(CommandTypes.Visitor);
                isActive = false;
            } else if (userSelection == 2) {
                boolean isLoggedIn = loginVisitor();
                if (isLoggedIn) {
                    setNextCommands(CommandTypes.Visitor);
                    isActive = false;
                }
            } else if (userSelection == 3) {
                boolean isLoggedIn = loginZookeeper();
                if (isLoggedIn) {
                    setNextCommands(CommandTypes.ZooKeeper);
                    isActive = false;
                }
            } else {
                setNextCommands(CommandTypes.Exit);
                isActive = false;
            }
        }

    }
}