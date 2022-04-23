package com.company;

import java.time.LocalDateTime;
import java.util.UUID;

abstract class User {
    private String name;
    private LocalDateTime dateEntered;
    private boolean isStaff;
    private String id;


    public User(String name, boolean isStaff) {
        this.name = name;
        this.isStaff = isStaff;
        this.dateEntered = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
    }

    public boolean isStaff() {
        return isStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
