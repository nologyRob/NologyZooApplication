package com.company;

// TODO
// ANIMAL SCREEN? View animal

// ZooKeeper -
// Visitor - View Pen Stats, Feed all, Gain Pen Badge?
// ZooKeeper - View Pen Stats Feed all, Add / Remove animal

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        LoginCommands loginCommands = new LoginCommands(zoo);
        VisitorCommands visitorCommands = new VisitorCommands(zoo);
        AnimalCommands animalCommands = new AnimalCommands(zoo);
        ZookeeperCommands zookeeperCommands = new ZookeeperCommands(zoo);

        Commands currentScreen = loginCommands;
        boolean isRunning = true;

        while (isRunning) {

            currentScreen.runCommands();

            switch (currentScreen.getNextCommands()) {
                case Login:
                    currentScreen = loginCommands;
                    break;
                case Visitor:
                    currentScreen = visitorCommands;
                    break;
                case Animal:
                    currentScreen = animalCommands;
                    break;
                case ZooKeeper:
                    currentScreen = zookeeperCommands;
                    break;
                default:
                    System.out.println("Quiting");
                    isRunning = false;
                    break;
            }

        }

    }



}