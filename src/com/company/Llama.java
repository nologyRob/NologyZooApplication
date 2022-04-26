package com.company;

public class Llama extends Animal {
    public Llama(String name) {
        super(name, AnimalTypes.Llama.toString(), true);
    }

    @Override
    public void makeSound() {
        System.out.println("Hummmm");
    }
}
