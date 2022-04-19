package com.company;

import java.sql.Time;

public class Zookeeper extends Person{

    public Zookeeper(String name, int age, Time dateEntered) {
        super(name, age, dateEntered);
    }

    public static void addAnimal() {
        System.out.println("Zookeeper added an animal!");
    }
    public static void removeAnimal() {
        System.out.println("Zookeeper removed an animal!");
    }
    public static void feedAnimal() {
        System.out.println("Zookeeper fed an animal!");
    }
}

