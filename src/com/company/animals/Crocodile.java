package com.company.animals;

public class Crocodile extends Animal {
    public Crocodile(String name) {
        super(name, AnimalTypes.CROCODILE.toString(), false);
    }

    @Override
    public void makeSound() {
        System.out.println("Hiss, Hiss");
    }
}
