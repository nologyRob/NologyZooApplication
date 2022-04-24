package com.company;

import java.util.ArrayList;

// TODO
// OVERVIEW OF THE ZOO METHOD
// LOG IN ZOO KEEPER
// HASH SET & HASH MAP
// - ANIMAL TYPE : ANIMALS
// CREATE A LOOKUP MAP
// - SEARCHING ANIMALS
// ADD VISITORS IN ZOO FACTORY

public class Zoo {

    private final ArrayList<Animal> animals;
    private User currentUser;
    private ArrayList<Visitor> visitors;
//    private ArrayList<ZooKeeper> zooKeepers;

    public Zoo() {
        this.currentUser = null;
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        visitors.add(new Visitor("charlie", "test"));
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

    public void createVisitor(String name, String password) {
        Visitor visitor = new Visitor(name, password);
        addVisitor(visitor);
        setCurrentUser(visitor);
    }

    public void logOut() {
        setCurrentUser(null);
    }

    public boolean logInVisitor(String name, String password) {
        for (Visitor visitor : visitors) {
            if (visitor.authenticate(name, password)) {
                return true;
            }
        }

        return false;
    }

}
