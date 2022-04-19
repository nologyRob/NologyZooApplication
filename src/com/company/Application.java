package com.company;

import java.util.ArrayList;

public class Application {

    public static Zoo populateZoo(){

        Zoo zoo = new Zoo();
        System.out.println("\nYou have created a zoo! The zoo has " + zoo.getTotalAnimals() + " animals nd costs $" + zoo.getEntryPrice() );
        for (int i = 0; i <= zoo.getNumberOfZookeepers() ; i++) {
            Zookeeper zookeeper = new Zookeeper("Zookeeper"+i);
            zoo.setZooKeepers(zookeeper);
        }
        for (int i = 0; i < zoo.getVisitorCapacity()+1 ; i++) {
            Visitor visitor = new Visitor("Visitor"+i);
            zoo.setVisitors(visitor);
        }
        for (int i = 0; i < zoo.getTotalLions()+1 ; i++) {
            Lion lion = new Lion("Lion"+i);
            zoo.setLions(lion);
        }
        for (int i = 0; i < zoo.getTotalCrocodiles()+1 ; i++) {
            Crocodile crocodile = new Crocodile("Crocodile"+i);
            zoo.setCrocodiles(crocodile);
        }
        for (int i = 0; i < zoo.getTotalZebras()+1 ; i++) {
            Zebra zebra = new Zebra("Zebra"+i);
            zoo.setZebras(zebra);
        }
        zoo.getZooInfo();
        return zoo;
    }

}
