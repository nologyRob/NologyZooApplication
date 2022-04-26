package com.company;

public class Crocodile extends Animal {
    public Crocodile(String name) {
        super(name, AnimalTypes.Crocodile.toString(), false);
    }

    @Override
    public void makeSound() {
        System.out.println("Hiss, Hiss");
    }
}
