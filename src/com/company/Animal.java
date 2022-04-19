package com.company;

public abstract class Animal {
    private int age;
    private String name;

    public Animal(String name) {
        this.age = (int)(Math.random() * 20 + 1);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
