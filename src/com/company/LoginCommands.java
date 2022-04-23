package com.company;


// TODO
// LOG IN AS VISITOR
// LOG IN AS ZOO KEEPER

public class LoginCommands extends Commands {

    public LoginCommands(Zoo zoo) {
        super(new String[]{"Create a new Visitor", "Login as Visitor", "Login as Zoo Keeper", "Exit"}, "login", zoo);
    }

    public void createVisitor() {
        printMessage("Enter Details below");
        String name = getStringInput();
        Visitor visitor = new Visitor(name);
        getZoo().addVisitor(visitor);
        getZoo().setCurrentUser(visitor);
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
                setNextCommands(CommandNames.Visitor);
                isActive = false;
            } else if (userSelection == 2) {
                printMessage("How do you login?");
            } else if (userSelection == 3) {
                printMessage("Staff not set yet");
            } else {
                setNextCommands(CommandNames.Exit);
                isActive = false;
            }
        }

    }
}
