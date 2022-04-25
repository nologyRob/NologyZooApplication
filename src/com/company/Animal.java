package com.company;

import java.util.UUID;

// Visitor - Feed animal, Pet animal + Increment animals popularity.
public abstract class Animal {
    private int age;
    private String name;
    private int hunger;
    private int popularity;
    private boolean canPet;
    private int happiness;
    private String id;
    private String type;


    public Animal(String name, String type, boolean canPet) {
        this.age = (int) (Math.random() * 20 + 1);
        this.name = name;
        this.hunger = (int) (Math.random() * 100 + 1);
        this.canPet = canPet;
        this.popularity = 0;
        this.happiness = (int) (Math.random() * 100 + 1);
        this.id = UUID.randomUUID().toString().substring(0, 5);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isCanPet() {
        return canPet;
    }

    public void setCanPet(boolean canPet) {
        this.canPet = canPet;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    // TODO
    // ADD TO THIS
    public String getInfo() {
        return "This " + name.substring(0, name.length() - 1) + "id = " + id + " some info about it";
    }
}

