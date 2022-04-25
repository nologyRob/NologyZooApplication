package com.company;

import java.util.ArrayList;
import java.util.HashMap;

// TODO
// HASH SET -> USERNAMES?
// ADD VISITORS IN ZOO FACTORY

public class Zoo {

    private final ArrayList<Animal> animals;
    private User currentUser;
    private ArrayList<Visitor> visitors;
    private ArrayList<Zookeeper> zookeepers;
    private ArrayList<String> species;
    private HashMap<String, ArrayList<Animal>> speciesLookup;
    private HashMap<String, Animal> animalLookup;

    public Zoo() {
        this.currentUser = null;
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.species = new ArrayList<>();
        this.zookeepers = new ArrayList<>();
        this.speciesLookup = new HashMap<>();
        this.animalLookup = new HashMap<>();
        visitors.add(new Visitor("charlie", "test"));
        zookeepers.add(new Zookeeper("rob", "test"));
        ZooFactory.populateZoo(this);
    }

    public ArrayList<String> search(String searchTerm) {
        System.out.println(searchTerm);
        ArrayList<String> searchResults = new ArrayList<>();
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


    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public boolean hasAnimal(String animalId) {
        return animalLookup.containsKey(animalId);
    }

    public String getRandomAnimalId() {
        int index = (int) (Math.random() * animals.size());
        return animals.get(index).getId();
    }

    public void petAnimal(String animalId) {
        Animal animal = animalLookup.get(animalId);
        animal.pet();
    }

    public void giveToken(String animalId) {
        Animal animal = animalLookup.get(animalId);
        animal.giveToken();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        addToSpeciesLookup(animal);
        addToAnimalLookup(animal);
    }

    private void addToAnimalLookup(Animal animal) {
        String animalId = animal.getId();
        animalLookup.put(animalId, animal);
    }

    private void addToSpeciesLookup(Animal animal) {
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

    public ArrayList<Animal> getSpecies(AnimalTypes animalType) {

        switch (animalType) {
            case Lion:
                return speciesLookup.get(AnimalTypes.Lion.toString());
            case Llama:
                return speciesLookup.get(AnimalTypes.Llama.toString());
            case Crocodile:
                return speciesLookup.get(AnimalTypes.Crocodile.toString());
            default:
                return null;
        }

    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public void addAnimal(String animal) {
        Animal desiredAnimal = null;
        System.out.println("What type of animal are you looking to add?");
        switch (animal) {
            case "lion":
                desiredAnimal = new Lion("Lion" + getAnimals().size());
                break;
            case "llama":
                desiredAnimal = new Llama("Llama" + getAnimals().size());
                break;
            case "crocodile":
                desiredAnimal = new Crocodile("Crocodile" + getAnimals().size());
                break;
        }

        animals.add(desiredAnimal);
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

    public ArrayList<String> getZooOverview() {
        ArrayList<String> overview = new ArrayList<>();

        overview.add("The Zoo currently has " + animals.size() + " animals.");
        overview.add("The Zoo currently has " + visitors.size() + " visitors.");
        overview.add("The Current user is " + currentUser.getName());

        return overview;
    }

    public ArrayList<String> getAllAnimalInformation() {
        ArrayList<String> animalInformation = new ArrayList<>();

        animals.forEach(animal -> animalInformation.add(animal.getInformation()));

        return animalInformation;
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }


}