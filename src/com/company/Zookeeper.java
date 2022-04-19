package com.company;


import java.util.Objects;

public class Zookeeper extends Person {
    public Zookeeper(String name) {
        super(name);
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

    public void sortAnimals(Zoo zoo) {

        zoo.getAnimals().forEach(animal -> {
            if (Objects.equals(animal.getName(), "Lion")) {
                zoo.setLions((Lion) animal);
            } else if (Objects.equals(animal.getName(), "Crocodile")) {
                zoo.setCrocodiles((Crocodile) animal);
            } else {
                zoo.setZebras((Zebra) animal);
            }

        });

    }

}