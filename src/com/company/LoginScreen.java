package com.company;

public class LoginScreen extends Screen {

    public LoginScreen() {
        super(new String[]{"Login as Visitor", "Login as Staff", "Exit"});
    }

    public User runScreen() {
        printOptions();

        int userChoice = getIntegerInput();

        if (userChoice == getOptions().length) {
            printMessage("You have Quit");
            return null;
        } else if (userChoice == 2) {
            printMessage("You have logged in as a Staff");
            return null;
        } else {
            printMessage("Enter name");
            String name = getStringInput();
            return new Visitor(name);
        }
    }

    public void printOptions() {
        printMessage("Select an option:");
        printIndexedOptions();
        printMessage("Enter option:");
    }


}
