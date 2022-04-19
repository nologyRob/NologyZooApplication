package com.company;

import java.sql.Time;

public class Person {

    String name;
    int age;
    Time dateEntered;

    public Person(String name, int age, Time dateEntered) {
        this.name = name;
        this.age = age;
        this.dateEntered = dateEntered;
    }
}
