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

        Commands currentCommands = loginCommands;
        boolean isRunning = true;

        while (isRunning) {

            currentCommands.runCommands();

            switch (currentCommands.getNextCommands()) {
                case Login:
                    currentCommands = loginCommands;
                    break;
                case Visitor:
                    currentCommands = visitorCommands;
                    break;
                case Animal:
                    currentCommands = animalCommands;
                    break;
                case ZooKeeper:
                    currentCommands = zookeeperCommands;
                    break;
                default:
                    System.out.println("Quiting");
                    isRunning = false;
                    break;
            }

        }

    }


}