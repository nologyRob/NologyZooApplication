package com.company;

public class LoginCommands extends Commands {

    private boolean isLoggedIn;

    public LoginCommands() {
        super(new String[]{"Create a new Visitor", "Login as Visitor", "Login as Staff", "Exit"});
        isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public User createVisitor() {
        printMessage("Enter Details below");
        String name = getStringInput();
        return new Visitor(name);
    }

    @Override
    public void printOptions() {
        printMessage("Welcome to the Zoo");
        printIndexedOptions();
        printMessage("Enter Selection Below:");
    }

    @Override
    public int getUserSelection() {
        return getIntegerInput();
    }
}
