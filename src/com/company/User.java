package com.company;

import java.time.LocalDateTime;
import java.util.UUID;

abstract class User implements Searchable {
    private String name;
    private LocalDateTime dateEntered;
    private boolean isStaff;
    private String id;
    private String password;

    public User(String name, boolean isStaff, String password) {
        this.name = name;
        this.isStaff = isStaff;
        this.dateEntered = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.password = password;
    }

    public boolean isStaff() {
        return isStaff;
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
