package com.company;

public class LoginCommands extends Commands {

    private boolean isLoggedIn;
    private User currentUser;

    public LoginCommands() {
        super(new String[]{"Create a new Visitor", "Login as Visitor", "Login as Staff", "Exit"});
        isLoggedIn = false;
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String createVisitor() {
        printMessage("Enter Details below");
        return getStringInput();
    }


    @Override
    public void printCommands() {
        printMessage("Welcome to the Zoo");
        printIndexedOptions();
        printMessage("Enter Selection Below:");
    }

    @Override
    public int getUserSelection() {
        return getIntegerInput(getCommands().length);
    }

    @Override
    public int runCommands() {
        while (!isLoggedIn()) {
            printCommands();

            int userSelection = getUserSelection();

            if (userSelection == 1) {
                currentUser = new Visitor(createVisitor());
                setLoggedIn(true);
            } else if (userSelection == 4) {
                break;
            } else {
                System.out.println("Another option was pressed - Add to this");
            }
        }

        return -1;
    }
}
