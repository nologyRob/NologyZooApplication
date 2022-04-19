package com.company;

import java.time.LocalDateTime;

abstract class User {
    private String name;
    private LocalDateTime dateEntered;
    private boolean isStaff;


    public User(String name, boolean isStaff) {
        this.name = name;
        this.isStaff = isStaff;
        this.dateEntered = LocalDateTime.now();
    }

    public boolean isStaff() {
        return isStaff;
    }

    public String getName() {
        return name;
    }
}
