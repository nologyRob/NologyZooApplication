package com.company;

import java.util.ArrayList;
import java.util.HashMap;

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
    private ArrayList<Zookeeper> zookeepers;
    private ArrayList<String> species;
    private HashMap<String, ArrayList<Animal>> speciesLookup;

    public Zoo() {
        this.currentUser = null;
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.species = new ArrayList<>();
        this.zookeepers = new ArrayList<>();
        this.speciesLookup = new HashMap<>();
        visitors.add(new Visitor("charlie", "test"));
        zookeepers.add(new Zookeeper("rob", "test"));
        ZooFactory.populateZoo(this);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        updateSpeciesLookup(animal);
    }

    private void updateSpeciesLookup(Animal animal) {
        String animalType = animal.getType();

        if (speciesLookup.containsKey(animalType)) {
            speciesLookup.get(animalType).add(animal);
        } else {
            ArrayList<Animal> species = new ArrayList<>();
            species.add(animal);
            speciesLookup.put(animalType, species);
        }
    }

    public void addSpecies(String species) {
        this.species.add(species);
    }

    public ArrayList<String> getSpecies() {
        return species;
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
    public boolean logInZookeeper(String name, String password) {
        for (Zookeeper zookeeper : zookeepers) {
            if (zookeeper.authenticate(name, password)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<String> getZooOverview() {
        ArrayList<String> overview = new ArrayList<>();

        overview.add("The Zoo currently has " + animals.size() + " animals.");
        overview.add("The Zoo currently has " + visitors.size() + " visitors.");
        overview.add("The Current user is " + currentUser.getName());

        return overview;
    }

    public ArrayList<String> getAllAnimalInformation() {
        ArrayList<String> animalInformation = new ArrayList<>();

        animals.forEach(animal -> animalInformation.add(animal.getInfo()));

        return animalInformation;
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
}