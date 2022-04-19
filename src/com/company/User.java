package com.company;

import java.time.LocalDateTime;

abstract class User {
    String name;
    LocalDateTime dateEntered;
    boolean isStaff;

    public User(String name, boolean isStaff) {
        this.name = name;
        this.isStaff = isStaff;
        this.dateEntered = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }
}
