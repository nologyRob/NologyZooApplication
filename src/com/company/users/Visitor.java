package com.company.users;

public class Visitor extends User {
    private int animalTokens;
    private int happiness;

    public Visitor(String name, String password) {
        super(name, password, UserTypes.Visitor);
        this.animalTokens = 5;
        this.happiness = (int) (Math.random() * 100 + 1);
    }

    public void incrementHappiness() {
        happiness += 10;
    }

    public void decrementHappiness() {
        happiness -= 10;
    }

    public int getAnimalTokens() {
        return animalTokens;
    }

    public void spendToken() {
        this.animalTokens -= 1;
    }

    @Override
    public String getInformation() {
        return String.format("This %s, with the id: %s.\nHas %d tokens left and is %d happy.", name, id, animalTokens, happiness);
    }
}
