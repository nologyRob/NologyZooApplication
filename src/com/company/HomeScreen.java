package com.company;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super(new String[]{"Login as Visitor", "Login as Staff", "Exit"});
    }

    public void printOptions() {
        printMessage("Select an option:");
        printIndexedOptions();
        printMessage("Enter option:");
    }

    public int getUserSelection() {
        printOptions();
        return getIntegerInput();
    }


}
