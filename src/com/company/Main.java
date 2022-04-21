package com.company;

// TODO
// ANIMAL SCREEN? View animal

// ZooKeeper -
// PEN SCREEN?
// Visitor - View Pen Stats, Feed all, Gain Pen Badge?
// ZooKeeper - View Pen Stats Feed all, Add / Remove animal

public class Main {

    public static void main(String[] args) {
        LoginCommands login = new LoginCommands();
        login.runCommands();
        User currentUser = login.getCurrentUser();

        if (currentUser == null) {
            System.out.println("Quitting");
            return;
        }

        Zoo zoo = new Zoo();

        boolean isRunning = true;

        VisitorCommands visitorCommands = new VisitorCommands(zoo.getAnimals());
        AnimalCommands animalCommands = new AnimalCommands();
        Commands currentScreen = visitorCommands;

        while (isRunning) {

            int userSelection = currentScreen.runCommands();

            if (userSelection == 1) {
                currentScreen = visitorCommands;
            } else if (userSelection == 2) {
                currentScreen = animalCommands;
            } else {
                System.out.println("Quiting");
                isRunning = false;
            }

        }


    }



}
