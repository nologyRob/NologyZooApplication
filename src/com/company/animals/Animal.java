package com.company.animals;

import com.company.Searchable;

import java.util.UUID;


public abstract class Animal implements Searchable {
    private final String name;
    private final String id;
    private final String type;
    private final boolean canPet;
    private int hunger;
    private int popularity;

    public Animal(String name, String type, boolean canPet) {
        this.name = name;
        this.id = UUID.randomUUID().toString().substring(0, 5);
        this.type = type;
        this.hunger = (int) (Math.random() * 100 + 1);
        this.popularity = 0;
        this.canPet = canPet;
    }

    public String getType() {
        return type;
    }

    public boolean isCanPet() {
        return canPet;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getHunger() {
        return hunger;
    }

    public void feedAnimal() {
        this.hunger += 10;
    }

    public void pet() {
        this.popularity += 5;
    }

    public void receiveToken() {
        this.popularity += 50;
    }

    @Override
    public String getInformation() {
        return "The " + type + " with the id : " + id + " has a hunger of " + hunger + " and a popularity of " + popularity + ".";
    }

    @Override
    public boolean isMatch(String toMatch) {
        return name.contains(toMatch) || id.contains(toMatch) || type.contains(toMatch);
    }

    public abstract void makeSound();
}

