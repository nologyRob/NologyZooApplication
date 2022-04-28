package com.company.users;

import com.company.Searchable;

import java.util.UUID;

public abstract class User implements Searchable {
    protected final String id;
    private final String password;
    protected String name;
    protected UserTypes type;

    public User(String name, String password, UserTypes type) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean authenticate(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    @Override
    public boolean isMatch(String toMatch) {
        return name.contains(toMatch) || id.contains(toMatch);
    }
}
