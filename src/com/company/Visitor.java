package com.company;

public class Visitor extends User {
    int animalTokens;

    public Visitor(String name, String password) {
        super(name, false, password);
        this.animalTokens = 10;
    }


    // TODO
    // LOOK AT THIS
    public void giveToken(Zoo zoo, String animalName, int tokenAmount) {
        // Opportunity to learn about streams later in the code-along
        // Initially forEach
        zoo.getAnimals().forEach((animal) -> {
            if (animal.getName().equals(animalName)) {
                animal.setPopularity(animal.getPopularity() + tokenAmount);
                System.out.println("You have given " + animal.getName() + tokenAmount + (tokenAmount > 1 ? " tokens" : " token"));
            }
        });
        this.animalTokens = 10 - tokenAmount;
        System.out.println("You have " + this.animalTokens + " remaining");

    }

    public int getAnimalTokens() {
        return animalTokens;
    }

    public void setAnimalTokens(int animalTokens) {
        this.animalTokens = animalTokens;
    }

    @Override
    public String getInformation() {
        return "This " + getName() + "id = " + getId() + " has " + animalTokens + " left.";
    }
}
