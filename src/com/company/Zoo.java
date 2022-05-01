package com.company;

import com.company.animals.Animal;
import com.company.animals.AnimalTypes;
import com.company.users.Auth;
import com.company.users.Visitor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// TODO
// HASH SET -> USERNAMES?
// ADD VISITORS IN ZOO FACTORY

// REFACTOR LOGIN?
// - NEW AUTH CLASS?
// - AUTH USERS ZOO KEEPER


public class Zoo {

    // NOT TIED TO A CONCRETE IMPLEMENTATION -> DEPENDENCY INVERSION
    private final List<Animal> animals;
    private final List<String> animalTypes;
    private final Auth authentication;

    // LOOK UP ANIMAL BY ID -> CACHED
    // LOOK UP ANIMALS BY TYPE / SPECIES
    // ANIMAL DICTIONARY CLASS -> STORING & RETRIEVING ANIMALS
    private final Map<String, Animal> animalDictionary;
    private final Map<String, List<Animal>> animalsByTypeDictionary;


    public Zoo(Auth authentication) throws FileNotFoundException {
        this.animals = new ArrayList<>();
        this.animalTypes = new ArrayList<>();
        this.animalsByTypeDictionary = new HashMap<>();
        this.animalDictionary = new HashMap<>();
        this.authentication = authentication;
        ZooFactory.populateZoo(this);
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

        toSearch.addAll(authentication.getVisitors());
        toSearch.addAll(animals);
        toSearch.addAll(authentication.getZookeepers());

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

    public String getRandomAnimalId() {
        int index = (int) (Math.random() * animals.size());
        return animals.get(index).getId();
    }

    public List<String> getAnimalTypes() {
        return animalTypes;
    }

    public String getZooOverview() {
        return String.format("The Zoo currently has %d animals.\nThe Zoo currently has %d visitors.\nThe Current user is %s.", animals.size(), authentication.getVisitors().size(), authentication.getCurrentUser().getName());
    }

    public String getAnimalInformation(String animalId) {
        Animal animal = animalDictionary.get(animalId);
        return animal.getInformation();
    }

    public String getAnimalInformation(List<Animal> animals) {
        StringBuilder animalOverview = new StringBuilder();

        for (Animal animal : animals) {
            animalOverview.append(animal.getInformation());
            animalOverview.append("\n");
        }

        return animalOverview.toString();
    }

    public String getAnimalInformationByType(AnimalTypes animalType) {
        List<Animal> animalsByType;
        switch (animalType) {
            case LION:
                animalsByType = animalsByTypeDictionary.get(AnimalTypes.LION.toString());
                break;
            case LLAMA:
                animalsByType = animalsByTypeDictionary.get(AnimalTypes.LLAMA.toString());
                break;
            default:
                animalsByType = animalsByTypeDictionary.get(AnimalTypes.CROCODILE.toString());
        }

        return getAnimalInformation(animalsByType);
    }

    public String getAllAnimalsInformation() {
        return getAnimalInformation(animals);
    }

    public String getUsersName() {
        return authentication.getCurrentUser().getName();
    }

    private List<Animal> getHungryAnimals() {
        return animals.stream().filter(animal -> animal.getHunger() < 50).collect(Collectors.toList());
    }

    public String getHungryAnimalInformation() {
        List<Animal> hungryAnimals = getHungryAnimals();
        return getAnimalInformation(hungryAnimals);
    }

    // --- UPDATE ---

    public void feedHungryAnimals() {
        List<Animal> hungryAnimals = getHungryAnimals();
        hungryAnimals.forEach(Animal::feedAnimal);
    }

    public void updateUser(String name) {
        authentication.getCurrentUser().setName(name);
    }

    public boolean petAnimal(String animalId) {
        Animal animal = animalDictionary.get(animalId);
        Visitor currentVisitor = (Visitor) this.authentication.getCurrentUser();

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
        Visitor currentUser = (Visitor) authentication.getCurrentUser();

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