package com.company;

import java.util.ArrayList;

public class Zoo {

    private int totalAnimals;
    private int totalLions;
    private int totalCrocodiles;
    private int totalZebras;
    private double entryPrice;
    private int numberOfZookeepers;
    private int visitorCapacity;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Animal> lions = new ArrayList<>();
    private ArrayList<Animal> crocodiles = new ArrayList<>();
    private ArrayList<Animal> zebras = new ArrayList<>();
    private ArrayList<Zookeeper> zooKeepers = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public Zoo() {
        this.totalLions = (int)(Math.random() * 50 + 1);
        this.totalCrocodiles = (int)(Math.random() * 50 + 1);
        this.totalZebras = (int)(Math.random() * 50 + 1);
        this.totalAnimals = this.totalCrocodiles+this.totalLions+this.totalZebras;
        this.entryPrice = (int)(Math.random() * 10 + 1);
        this.numberOfZookeepers = (int)(Math.random() * 3 + 1);
        this.visitorCapacity = (int)(Math.random() * 1000 + 1);
    }


    public int getTotalAnimals() {
        return totalAnimals;
    }

    public int getTotalLions() {
        return totalLions;
    }

    public int getTotalCrocodiles() {
        return totalCrocodiles;
    }

    public int getTotalZebras() {
        return totalZebras;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public int getNumberOfZookeepers() {
        return numberOfZookeepers;
    }

    public int getVisitorCapacity() {
        return visitorCapacity;
    }

    public void getZooInfo() {
        System.out.println("\n This zoo has the following:\n" +
                "There are " + getTotalZebras() + " Zebras\n" +
                "There are " + getTotalLions() + " Lions\n" +
                "There are " + getTotalCrocodiles() + " Crocodiles\n" +
                "There are " + getNumberOfZookeepers() + " Zookeepers\n" +
                "There are " + getVisitorCapacity() + " spaces available in this zoo");
    }

    public void printAnimals(){
        animals.forEach(animal -> System.out.println(animal.getName()));
    }

    public void setAnimals(Animal animal) {
        animals.add(animal);
    }

    public void setLions(Lion lion) {
        lions.add(lion);
    }

    public void setCrocodiles(Crocodile crocodile) {
        crocodiles.add(crocodile);
    }

    public void setZebras(Zebra zebra) {
        zebras.add(zebra);
    }

    public void setZooKeepers(Zookeeper zooKeeper) {
        zooKeepers.add(zooKeeper);
    }

    public void setVisitors(Visitor visitor) {
        visitors.add(visitor);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Animal> getLions() {
        return lions;
    }

    public ArrayList<Animal> getCrocodiles() {
        return crocodiles;
    }

    public ArrayList<Animal> getZebras() {
        return zebras;
    }

    public ArrayList<Zookeeper> getZooKeepers() {
        return zooKeepers;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }
}
