package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Pen<T extends Animal> {
    private final ArrayList<T> animalsInPen;
    private final String name;
    private int cleanliness;

    public Pen(String name) {
        this.name = name;
        this.animalsInPen = new ArrayList<T>();
    }

    public Pen(ArrayList<T> animalsInPen, String name) {
        this.animalsInPen = animalsInPen;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAnimalToPen(T animal) {
        animalsInPen.add(animal);
    }

    public ArrayList<T> getAnimalsInPen() {
        return animalsInPen;
    }

    public T getAnimal(String name) {

        for (T animal : animalsInPen) {
            if (Objects.equals(name, animal.getName())) {
                return animal;
            }
        }

        return null;
    }

    public void setCleanliness() {
        this.cleanliness = cleanliness+=5;
    }

    public int getCleanliness() {
        return cleanliness;
    }
}
