package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    String choice;
    static Zoo zoo;



    static boolean zooActive = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(zooActive){
            System.out.println("Press Y to create a new Zoo or Q to quit!");
            String choice = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch(choice){
                case "y":
                    System.out.println("You chose Y");
                    zoo = Application.populateZoo();

                    break;
                case "q":
                    zooActive = false;
                    break;

            }
            System.out.println("" +
                    "Press A to see all the animals\n" +
                    "Press B to get the ZooKeeper to organise the animals into pens\n" +
                    " or Q to quit");

            choice = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch(choice){
                case "a":
                    zoo.printAnimals();
                    break;
                case "b":
                zoo.getZooKeepers().get(1).sortAnimals(zoo);
                    System.out.println("The animals have been sorted into pens!");
                    System.out.println(zoo.getLions());
                break;
                case "q":
                    zooActive = false;
                    break;

            }
        }
    }
}
