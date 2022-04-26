package com.company;


// TODO
// ONE LOG METHOD

public class LoginCommands extends Commands {
    public LoginCommands(Zoo zoo) {
        super(new String[]{"Create a new Visitor", "Login as Visitor", "Login as Zoo Keeper", "Exit"}, "login", zoo);
    }

    public void createVisitor() {
        String name = getStringInput("Enter Name below:");
        String password = getStringInput("Enter Password below:");
        getZoo().createVisitor(name, password);
    }

    public boolean loginVisitor() {
        boolean isActive = true;
        boolean isLoggedIn = false;

        while (isActive) {
            String name = getStringInput("Enter Name below:");
            String password = getStringInput("Enter Password below:");
            isLoggedIn = getZoo().logInVisitor(name, password);

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

    public boolean loginZookeeper() {
        boolean isActive = true;
        boolean isLoggedIn = false;

        while (isActive) {
            String name = getStringInput("Enter Name below:");
            String password = getStringInput("Enter Password below:");
            isLoggedIn = getZoo().logInZookeeper(name, password);

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
                setNextCommands(CommandNames.Visitor);
                isActive = false;
            } else if (userSelection == 2) {
                boolean isLoggedIn = loginVisitor();
                if (isLoggedIn) {
                    setNextCommands(CommandNames.Visitor);
                    isActive = false;
                }
            } else if (userSelection == 3) {
                boolean isLoggedIn = loginZookeeper();
                if (isLoggedIn) {
                    setNextCommands(CommandNames.ZooKeeper);
                    isActive = false;
                }
            } else {
                setNextCommands(CommandNames.Exit);
                isActive = false;
            }
        }

    }
}