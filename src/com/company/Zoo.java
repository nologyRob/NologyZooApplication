package com.company;

import java.util.ArrayList;
import java.util.HashMap;

// TODO
// HASH SET -> USERNAMES?
// ADD VISITORS IN ZOO FACTORY

public class Zoo {

    private final ArrayList<Animal> animals;
    private final ArrayList<Visitor> visitors;
    private final ArrayList<Zookeeper> zookeepers;
    private final ArrayList<String> animalTypes;

    private final HashMap<String, Animal> animalLookup;
    private final HashMap<String, ArrayList<Animal>> animalsByTypeLookup;

    private User currentUser;

    public Zoo() {
        this.currentUser = null;
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.animalTypes = new ArrayList<>();
        this.zookeepers = new ArrayList<>();

        this.animalsByTypeLookup = new HashMap<>();
        this.animalLookup = new HashMap<>();
        // MOVE TO ZOO FACTORY
        visitors.add(new Visitor("charlie", "test"));
        zookeepers.add(new Zookeeper("rob", "test"));

        ZooFactory.populateZoo(this);
    }

    public ArrayList<String> searchZoo(String searchTerm) {

        ArrayList<String> searchResults = new ArrayList<String>();
        ArrayList<Searchable> toSearch = new ArrayList<Searchable>();

        toSearch.addAll(visitors);
        toSearch.addAll(animals);
        toSearch.addAll(zookeepers);

        for (Searchable searchableItem : toSearch) {
            if (searchableItem.isMatch(searchTerm)) {
                searchResults.add(searchableItem.getInformation());
            }
        }

        return searchResults;
    }

    public boolean hasAnimal(String animalId) {
        return animalLookup.containsKey(animalId);
    }

    public String getRandomAnimalId() {
        int index = (int) (Math.random() * animals.size());
        return animals.get(index).getId();
    }

    public boolean petAnimal(String animalId) {
        Animal animal = animalLookup.get(animalId);
        Visitor currentVisitor = (Visitor) this.currentUser;

        if (animal.isCanPet()) {
            animal.pet();
            currentVisitor.incrementHappiness();
            return true;
        } else {
            currentVisitor.decrementHappiness();
            return false;
        }
    }

    public boolean spendAnimalToken(String animalId) {
        Visitor currentUser = (Visitor) this.currentUser;

        if (currentUser.getAnimalTokens() > 0) {
            Animal animal = animalLookup.get(animalId);
            animal.receiveToken();
            currentUser.incrementHappiness();
            currentUser.spendToken();
            return true;
        } else {
            currentUser.decrementHappiness();
            return false;
        }

    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        addAnimalsByTypeLookup(animal);
        addToAnimalLookup(animal);
    }

    private void addToAnimalLookup(Animal animal) {
        String animalId = animal.getId();
        animalLookup.put(animalId, animal);
    }

    private void addAnimalsByTypeLookup(Animal animal) {
        String animalType = animal.getType();

        if (animalsByTypeLookup.containsKey(animalType)) {
            animalsByTypeLookup.get(animalType).add(animal);
        } else {
            ArrayList<Animal> species = new ArrayList<>();
            species.add(animal);
            animalsByTypeLookup.put(animalType, species);
        }
    }

    public void addAnimalTypes(String animalType) {
        this.animalTypes.add(animalType);
    }

    public ArrayList<Animal> getAnimalByType(AnimalTypes animalType) {
        switch (animalType) {
            case Lion:
                return animalsByTypeLookup.get(AnimalTypes.Lion.toString());
            case Llama:
                return animalsByTypeLookup.get(AnimalTypes.Llama.toString());
            case Crocodile:
                return animalsByTypeLookup.get(AnimalTypes.Crocodile.toString());
            default:
                return null;
        }
    }

    public ArrayList<String> getAnimalTypes() {
        return animalTypes;
    }

    public void addAnimal(AnimalTypes animalType) {
        int numberOfAnimals = animalsByTypeLookup.get(animalType.toString()).size();
        Animal animal = ZooFactory.createAnimal(animalType, numberOfAnimals);
        addAnimal(animal);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void setCurrentUser(User currentUser) {
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
                setCurrentUser(visitor);
                return true;
            }
        }

        return false;
    }

    public boolean logInZookeeper(String name, String password) {
        for (Zookeeper zookeeper : zookeepers) {
            if (zookeeper.authenticate(name, password)) {
                setCurrentUser(zookeeper);
                return true;
            }
        }

        return false;
    }

    public String getZooOverview() {
        return String.format("The Zoo currently has %d animals.\nThe Zoo currently has %d visitors.\nThe Current user is %s.", animals.size(), visitors.size(), currentUser.getName());
    }

    public String getAnimalsOverview() {
        StringBuilder animalOverview = new StringBuilder();

        for (Animal animal : animals) {
            animalOverview.append(animal.getInformation());
            animalOverview.append("\n");
        }

        return animalOverview.toString();
    }


    public boolean removeAnimal(String animalId) {
        if (animalLookup.containsKey(animalId)) {
            Animal animalToRemove = animalLookup.get(animalId);
            animals.remove(animalToRemove);
            animalLookup.remove(animalId);
            animalsByTypeLookup.remove(animalToRemove.getType()).remove(animalToRemove);
            return true;
        } else {
            return false;
        }
    }
}