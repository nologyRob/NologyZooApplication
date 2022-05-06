package com.company.animals;

public class Lion extends Animal {

    public Lion(String name) {
        super(name, AnimalTypes.LION.toString(), false);
    }

    @Override
    public void makeSound() {
        System.out.println("Grrrrrrrrr");
    }

}