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

    public Zoo() {
        this.animals = new ArrayList<>();
        ZooFactory.populateZoo(this);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }


}
