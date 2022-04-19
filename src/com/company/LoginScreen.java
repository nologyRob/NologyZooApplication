package com.company;

public class LoginScreen extends Screen {
    private boolean isValid;

    public LoginScreen() {
        super(new String[]{"Login as Visitor", "Login as Staff", "Exit"});
        isValid = false;
    }

    public boolean loadScreen() {
        printIndexedOptions();

        int inputOption = getIntegerInput();

        if (inputOption == options.length) {
            return false;
        }


        return true;
    }
}
