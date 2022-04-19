package com.company;

public class Visitor extends User {
    int animalTokens;

    public Visitor(String name) {
        super(name, false);
        this.animalTokens = 10;
    }


}
