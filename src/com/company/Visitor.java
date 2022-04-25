package com.company;

public class Visitor extends User {
    int animalTokens;

    public Visitor(String name, String password) {
        super(name, false, password);
        this.animalTokens = 10;
    }

}
