package com.company;

public class Crocodile extends Animal implements Behaviour {

    public Crocodile(String name) {
        super(name);

    }

    @Override
    public void breathe() {
        System.out.println("Snap snap breathe");
    }

    @Override
    public void drink() {
        System.out.println("Snap snap slurp");
    }

    @Override
    public void eat() {
        System.out.println("Snap snap waddle");
    }

    @Override
    public void sleep() {
        System.out.println("Snap snap night night");
    }
}
