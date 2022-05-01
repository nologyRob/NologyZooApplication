package com.company.users;

public class Zookeeper extends User {

    public Zookeeper(String name, String password) {
        super(name, password, UserTypes.ZOOKEEPER);
    }

    @Override
    public String getInformation() {
        return "This " + getName() + "id = " + getId();
    }
}