package com.company;

import com.company.animals.Animal;
import com.company.animals.AnimalTypes;
import com.company.users.User;
import com.company.users.Visitor;
import com.company.users.Zookeeper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO
// HASH SET -> USERNAMES?
// ADD VISITORS IN ZOO FACTORY
// REFACTOR LOGIN?
// - NEW AUTH CLASS?

// ORGANISE PACKAGES
// - ANIMALS
// - COMMANDS
// - ZOO
// - AUTH USERS ZOO KEEPER

// CLASS DIAGRAMS -> EACH STAGE

// COMPARABLE INTERFACE

// READ FROM CSV FILE ZOO FACTORY -> VIA INTERFACE

public class Zoo {

    // NOT TIED TO A CONCRETE IMPLEMENTATION -> DEPENDENCY INVERSION
    private final List<Animal> animals;
    private final List<User> visitors;
    private final List<User> zookeepers;
    private final List<String> animalTypes;

    // LOOK UP ANIMAL BY ID -> CACHED
    // LOOK UP ANIMALS BY TYPE / SPECIES
    // ANIMAL DICTIONARY CLASS -> STORING & RETRIEVING ANIMALS
    private final Map<String, Animal> animalDictionary;
    private final Map<String, List<Animal>> animalsByTypeDictionary;

    private User currentUser;

    public Zoo() throws FileNotFoundException {
        this.currentUser = null;
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.animalTypes = new ArrayList<>();
        this.zookeepers = new ArrayList<>();

        this.animalsByTypeDictionary = new HashMap<>();
        this.animalDictionary = new HashMap<>();
        // MOVE TO ZOO FACTORY
        visitors.add(new Visitor("charlie", "test"));
        zookeepers.add(new Zookeeper("rob", "test"));

        ZooFactory.populateZoo(this);
    }

    // --- LOGIN / LOGOUT ---
    // AUTH SERVICE -> SECURITY -> IMPLEMENTATION
    // LESSON -> DOING TO MUCH -> SINGLE USE

    public void createVisitor(String name, String password) {
        Visitor visitor = new Visitor(name, password);
        visitors.add(visitor);
        currentUser = visitor;
    }

    public void logOut() {
        currentUser = null;
    }

    private boolean logIn(String name, String password, List<User> users) {
        for (User user : users) {
            if (user.authenticate(name, password)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    public boolean logInVisitor(String name, String password) {
        return logIn(name, password, visitors);
    }

    public boolean logInZookeeper(String name, String password) {
        return logIn(name, password, zookeepers);
    }

    // --- CREATE ---

    public void addAnimalTypes(String animalType) {
        this.animalTypes.add(animalType);
    }

    public void createAnimal(AnimalTypes animalType) {
        int numberOfAnimals = animalsByTypeDictionary.get(animalType.toString()).size();
        Animal animal = ZooFactory.createAnimal(animalType, numberOfAnimals);
        addAnimal(animal);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        addToAnimalDictionary(animal);
        addToAnimalsByTypeDictionary(animal);
    }

    private void addToAnimalDictionary(Animal animal) {
        String animalId = animal.getId();
        animalDictionary.put(animalId, animal);
    }

    private void addToAnimalsByTypeDictionary(Animal animal) {
        String animalType = animal.getType();

        if (animalsByTypeDictionary.containsKey(animalType)) {
            animalsByTypeDictionary.get(animalType).add(animal);
        } else {
            ArrayList<Animal> species = new ArrayList<>();
            species.add(animal);
            animalsByTypeDictionary.put(animalType, species);
        }
    }

    // --- READ ---

    public ArrayList<String> searchZoo(String searchTerm) {

        ArrayList<String> searchResults = new ArrayList<>();
        ArrayList<Searchable> toSearch = new ArrayList<>();

        toSearch.addAll(visitors);
        toSearch.addAll(animals);
        toSearch.addAll(zookeepers);

        for (Searchable searchableItem : toSearch) {
            if (searchableItem.isMatch(searchTerm)) {
                searchResults.add(searchableItem.getInformation());
            }
        }
        // capture searchable things -> what can you do?
        // RETURN A LIST OF SEARCHABLE ->
        return searchResults;
    }

    public boolean hasAnimal(String animalId) {
        return animalDictionary.containsKey(animalId);
    }

    public List<Animal> getAnimalsByType(AnimalTypes animalType) {
        switch (animalType) {
            case Lion:
                return animalsByTypeDictionary.get(AnimalTypes.Lion.toString());
            case Llama:
                return animalsByTypeDictionary.get(AnimalTypes.Llama.toString());
            case Crocodile:
                return animalsByTypeDictionary.get(AnimalTypes.Crocodile.toString());
            default:
                return null;
        }
    }

    public String getRandomAnimalId() {
        int index = (int) (Math.random() * animals.size());
        return animals.get(index).getId();
    }

    public List<String> getAnimalTypes() {
        return animalTypes;
    }

    public String getZooOverview() {
        return String.format("The Zoo currently has %d animals.\nThe Zoo currently has %d visitors.\nThe Current user is %s.", animals.size(), visitors.size(), currentUser.getName());
    }

    public String getAnimalInformation(String animalId) {
        Animal animal = animalDictionary.get(animalId);
        return animal.getInformation();
    }

    public String getAllAnimalsInformation() {
        StringBuilder animalOverview = new StringBuilder();

        for (Animal animal : animals) {
            animalOverview.append(animal.getInformation());
            animalOverview.append("\n");
        }

        return animalOverview.toString();
    }

    public String getUsersName() {
        return currentUser.getName();
    }

    // --- UPDATE ---

    public void updateUser(String name) {
        currentUser.setName(name);
    }

    public boolean petAnimal(String animalId) {
        Animal animal = animalDictionary.get(animalId);
        Visitor currentVisitor = (Visitor) this.currentUser;

        animal.makeSound();

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
            Animal animal = animalDictionary.get(animalId);
            animal.receiveToken();
            currentUser.incrementHappiness();
            currentUser.spendToken();
            return true;
        } else {
            currentUser.decrementHappiness();
            return false;
        }

    }

    // --- DELETE ---

    public boolean removeAnimal(String animalId) {
        if (animalDictionary.containsKey(animalId)) {
            Animal animalToRemove = animalDictionary.get(animalId);
            animals.remove(animalToRemove);
            animalDictionary.remove(animalId);
            animalsByTypeDictionary.remove(animalToRemove.getType()).remove(animalToRemove);
            return true;
        } else {
            return false;
        }
    }

}