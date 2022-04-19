package com.company;

public class Main {


    public static void main(String[] args) {
        LoginScreen currentScreen = new LoginScreen();
        User user = currentScreen.runScreen();
        System.out.println(user.getName());
    }
}
