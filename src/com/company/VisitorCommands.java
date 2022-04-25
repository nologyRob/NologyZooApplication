package com.company;

public class VisitorCommands extends Commands {

    public VisitorCommands(Zoo zoo) {
        super(new String[]{"See Zoo Overview", "Visit Animal", "Edit Information", "Log off", "Exit"}, "Visitor", zoo);
    }

    public void printAnimals() {
        for (Animal animal : getZoo().getAnimals()) {
            printMessage(animal.getInfo());
        }
    }

    public void updateUser() {
        User user = getZoo().getCurrentUser();
        printMessage("Hello " + user.getName());
        printMessage("Enter your new name below");
        String newName = getStringInput();
        user.setName(newName);
        printMessage("Your name has been updated");
    }

    @Override
    public void printCommands() {
        printMessage("Welcome to the " + getName() + " commands.");
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
                printAnimals();
            } else if (userSelection == 2) {
                setNextCommands(CommandNames.Animal);
                isActive = false;
            } else if (userSelection == 3) {
                updateUser();
            } else if (userSelection == 4) {
                getZoo().logOut();
                setNextCommands(CommandNames.Login);
                isActive = false;
            } else {
                setNextCommands(CommandNames.Exit);
                isActive = false;
            }
        }
    }


}
