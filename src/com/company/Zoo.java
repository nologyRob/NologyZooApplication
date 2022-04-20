package com.company;

import java.util.ArrayList;

public class Zoo {
    private User currentUser;
    private ArrayList<Animal> lions = new ArrayList<>();

    public Zoo(User currentUser) {
        this.currentUser = currentUser;
        for (int i = 0; i < 5; i++) {
            Lion lion = new Lion("Lion" + i);
            lions.add(lion);
        }
    }

    public ArrayList<Animal> getLions() {
        return lions;
    }
}
