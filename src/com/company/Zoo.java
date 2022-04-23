package com.company;

import java.util.ArrayList;

// TODO
// OVERVIEW OF THE ZOO METHOD
// LOG IN
// HASH SET & HASH MAP
// - ANIMAL TYPE : ANIMALS
// CREATE A LOOKUP MAP
// - SEARCHING ANIMALS
//

public class Zoo {

    private final ArrayList<Animal> animals;
    private User currentUser;
    private ArrayList<Visitor> visitors;
//    private ArrayList<ZooKeeper> zooKeepers;

    public Zoo() {
        this.currentUser = null;
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        ZooFactory.populateZoo(this);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
}
