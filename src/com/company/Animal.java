package com.company;

public abstract class Animal {
    private int age;
    private String name;
    private int hunger;

    public Animal(String name) {
        this.age = (int) (Math.random() * 20 + 1);
        this.name = name;
        this.hunger = (int) (Math.random() * 100 + 1);
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}

