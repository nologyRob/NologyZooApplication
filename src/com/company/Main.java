package com.company;

public class Main {

    public static void main(String[] args) {
        LoginScreen login = new LoginScreen();
        User currentUser = null;

        while (!login.isLoggedIn()) {
            login.printOptions();
            int userSelection = login.getUserSelection();
            if (userSelection == 1) {
                currentUser = login.createVisitor();
                login.setLoggedIn(true);
            } else if (userSelection == login.getOptions().length) {
                break;
            } else {
                System.out.println("Another option was pressed - Add to this");
            }
        }

        if (currentUser == null) {
            System.out.println("Quitting");
            return;
        }

        Zoo zoo = new Zoo(currentUser);
        boolean isRunning = true;

        while (isRunning) {
            // CURRENTLY VISITOR OPTIONS - ARRAY OF SCREENS?
            VisitorScreen visitorScreen = new VisitorScreen(new String[]{"Display animals", "Display pens", "Exit"}, currentUser.isStaff());

            int userSelection = visitorScreen.getUserSelection();

            if (userSelection == 1) {
                visitorScreen.printAnimals(zoo.getLions());
            } else {
                System.out.println("Quiting");
                isRunning = false;
            }

        }


    }
}
