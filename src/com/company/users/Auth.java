package com.company.users;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Auth {
    private final List<User> visitors;
    private final List<User> zookeepers;
    private User currentUser;

    public Auth() throws FileNotFoundException {
        this.visitors = new ArrayList<>();
        this.zookeepers = new ArrayList<>();
        AuthFactory.populateAuth(this);
    }

    public void createVisitor(String name, String password) {
        Visitor visitor = new Visitor(name, password);
        visitors.add(visitor);
        currentUser = visitor;
    }

    public void logOut() {
        currentUser = null;
    }

    public boolean logIn(UserTypes type, String name, String password) {

        List<User> users = type == UserTypes.ZOOKEEPER ? zookeepers : visitors;

        for (User user : users) {
            if (user.authenticate(name, password)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    public List<User> getVisitors() {
        return visitors;
    }

    public List<User> getZookeepers() {
        return zookeepers;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addZookeeper(Zookeeper zookeeper) {
        zookeepers.add(zookeeper);
    }


    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
}
