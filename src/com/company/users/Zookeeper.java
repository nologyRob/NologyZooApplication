package com.company.users;

public class Zookeeper extends User {

    public Zookeeper(String name, String password) {
        super(name, true, password);
    }

    @Override
    public String getInformation() {
        return "This " + getName() + "id = " + getId();
    }
}