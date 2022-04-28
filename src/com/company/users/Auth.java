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
