package com.company.users;

import com.company.CSVDataLoader;
import com.company.DataLoader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class AuthFactory {
    public static void populateAuth(Auth auth) throws FileNotFoundException {
        DataLoader csvLoader = new CSVDataLoader();
        List<String[]> userDetails = csvLoader.createUsers("users.csv");

        for (String[] userDetail : userDetails) {
            if (Objects.equals(userDetail[0], UserTypes.Zookeeper.toString())) {
                auth.addZookeeper(new Zookeeper(userDetail[1], userDetail[2]));
            } else {
                auth.addVisitor(new Visitor(userDetail[1], userDetail[2]));
            }

        }

    }

}
