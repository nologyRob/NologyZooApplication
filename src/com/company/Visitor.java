package com.company;

public class Visitor extends User {
    int animalTokens;

    public Visitor(String name) {
        super(name, false);
        this.animalTokens = 10;
    }

    public void giveToken(Zoo zoo,String animalName, int tokenAmount){
        zoo.getAnimals().forEach((animal) -> {
            if (animal.getName().equals(animalName)) {
                animal.setPopularity(animal.getPopularity()+tokenAmount);
                System.out.println("You have given " + animal.getName() + tokenAmount + (tokenAmount > 1 ? " tokens": " token"));
            }
        });

    }

    public int getAnimalTokens() {
        return animalTokens;
    }

    public void setAnimalTokens(int animalTokens) {
        this.animalTokens = animalTokens;
    }
}
