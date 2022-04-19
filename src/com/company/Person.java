package com.company;


import java.sql.Time;
import java.time.LocalDateTime;

public class Person implements Behaviour{
    String name;
    int age;
    LocalDateTime dateEntered;

    public Person(String name) {
        this.name = name;
        this.age = (int)(Math.random() * 100 + 1);
        this.dateEntered = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    @Override
    public void breathe() {
        System.out.println("Human breathe");
    }

    @Override
    public void drink() {
        System.out.println("Human drink");
    }

    @Override
    public void eat() {
        System.out.println("Human eat");
    }

    @Override
    public void sleep() {
        System.out.println("Human sleep");
    }
}
