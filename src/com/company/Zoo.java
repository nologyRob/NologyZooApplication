package com.company;

import java.util.ArrayList;

// TODO
// HASH SET & HASH MAP
// ANIMAL TYPE : ANIMALS
// PEN :
// CREATE A LOOKUP MAP
// LIST OF PENS -> PEN KNOW ANIMALS
// LIST OF ALL ANIMALS
// HASH SETS FOR UNIQUENESS WHEN ZOO-KEEPER ADDS IT

public class Zoo {

    private ArrayList<Animal> animals;
    private ArrayList<Pen<Animal>> pens;

    public Zoo() {
        this.animals = new ArrayList<>();
        this.pens = new ArrayList<>();
        ZooFactory.populateZoo(this);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Pen<Animal>> getPens() {
        return pens;
    }

    public void setPens(ArrayList<Pen<Animal>> pens) {
        this.pens = pens;
    }

    public void addPen(Pen<Animal> pen) {
        pens.add(pen);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }


}
