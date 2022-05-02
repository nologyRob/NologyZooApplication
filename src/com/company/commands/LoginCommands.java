package com.company.commands;


import com.company.users.Auth;
import com.company.users.UserTypes;

public class LoginCommands extends Commands {
    private final Auth authentication;

    public LoginCommands(Auth authentication) {
        super(new String[]{"Create a new Visitor", "Login as Visitor", "Login as Zoo Keeper", "Exit"}, "login");
        this.authentication = authentication;
    }

    private void createVisitor() {
        String name = getStringInput("Enter Name below:");
        String password = getStringInput("Enter Password below:");
        authentication.createVisitor(name, password);
    }

    private boolean loginUser(UserTypes type) {
        boolean isActive = true;
        boolean isLoggedIn = false;

        while (isActive) {
            String name = getStringInput("Enter Name below:");
            String password = getStringInput("Enter Password below:");
            if (type == UserTypes.ZOOKEEPER) {
                isLoggedIn = authentication.logIn(UserTypes.ZOOKEEPER, name, password);
            } else {
                isLoggedIn = authentication.logIn(UserTypes.VISITOR, name, password);
            }

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
                setNextCommands(CommandTypes.VISITOR);
                isActive = false;
            } else if (userSelection == 2) {
                boolean isLoggedIn = loginUser(UserTypes.VISITOR);
                if (isLoggedIn) {
                    setNextCommands(CommandTypes.VISITOR);
                    isActive = false;
                }
            } else if (userSelection == 3) {
                boolean isLoggedIn = loginUser(UserTypes.ZOOKEEPER);
                if (isLoggedIn) {
                    setNextCommands(CommandTypes.ZOOKEEPER);
                    isActive = false;
                }
            } else {
                setNextCommands(CommandTypes.EXIT);
                isActive = false;
            }
        }

    }
}