package com.company.commands;

import com.company.Zoo;

public class VisitorCommands extends Commands {
    private final Zoo zoo;


    public VisitorCommands(Zoo zoo) {
        super(new String[]{"See Zoo Overview", "Visit Animal", "Edit Information", "Log off"}, "Visitor");
        this.zoo = zoo;
    }

    private void printOverview() {
        printMessage(zoo.getZooOverview());
    }

    private void updateUser() {
        printMessage("Hello " + zoo.getUsersName());

        String newName = getStringInput("Enter your new name below");

        zoo.updateUser(newName);

        printMessage("Your name has been updated");
    }

    @Override
    public void printCommands() {
        printGreeting();
        printMessage("Select an option:");
        printIndexedCommands();
        printMessage("Enter option:");
    }


    @Override
    public void runCommands() {
        boolean isActive = true;

        while (isActive) {
            printCommands();

            int userSelection = getIntegerInput();

            if (userSelection == 1) {
                printOverview();
            } else if (userSelection == 2) {
                setNextCommands(CommandTypes.Animal);
                isActive = false;
            } else if (userSelection == 3) {
                updateUser();
            } else {
                zoo.logOut();
                setNextCommands(CommandTypes.Login);
                isActive = false;
            }
        }
    }


}
