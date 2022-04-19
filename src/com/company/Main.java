package com.company;

public class Main {

    public static void main(String[] args) {
        HomeScreen home = new HomeScreen();


        app:
        while (true) {
            Screen nextScreen;

            int userSelection = home.getUserSelection();
            switch (userSelection) {
                case 1:
                    nextScreen = new VisitorScreen();
                    nextScreen.printIndexedOptions();
                    break;
                case 2:
                    System.out.println("Login as Staff");
                    break;
                default:
                    break app;
            }


        }


    }
}
