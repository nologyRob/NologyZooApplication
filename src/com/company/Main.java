package com.company;

import com.company.commands.*;
import com.company.users.Auth;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Auth authentication = new Auth();
        Zoo zoo = new Zoo(authentication);


        Commands loginCommands = new LoginCommands(authentication);
        Commands visitorCommands = new VisitorCommands(zoo, authentication);
        Commands animalCommands = new AnimalCommands(zoo);
        Commands zookeeperCommands = new ZookeeperCommands(zoo, authentication);

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