package com.company;

import com.company.commands.*;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Commands loginCommands = new LoginCommands(zoo);
        Commands visitorCommands = new VisitorCommands(zoo);
        Commands animalCommands = new AnimalCommands(zoo);
        Commands zookeeperCommands = new ZookeeperCommands(zoo);

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