package com.company.animals;

public class Llama extends Animal {
    public Llama(String name) {
        super(name, AnimalTypes.LLAMA.toString(), true);
    }

    @Override
    public void makeSound() {
        System.out.println("Hummmm");
    }
}
