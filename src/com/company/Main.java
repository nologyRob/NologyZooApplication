package com.company;

// TODO
// ANIMAL SCREEN? View animal
// Visitor - Feed animal, Pet animal + Increment animals.
// ZooKeeper -
// PEN SCREEN?
// Visitor - View Pen Stats, Feed all, Gain Pen Badge?
// ZooKeeper - View Pen Stats Feed all, Add / Remove animal

public class Main {

    public static void main(String[] args) {
        LoginCommands login = new LoginCommands();
        User currentUser = null;

        while (!login.isLoggedIn()) {
            login.printOptions();
            int userSelection = login.getUserSelection();
            if (userSelection == 1) {
                currentUser = login.createVisitor();
                login.setLoggedIn(true);
            } else if (userSelection == login.getBaseOptions().length) {
                break;
            } else {
                System.out.println("Another option was pressed - Add to this");
            }
        }

        if (currentUser == null) {
            System.out.println("Quitting");
            return;
        }

        Zoo zoo = new Zoo();

        boolean isRunning = true;

        while (isRunning) {
            // CURRENTLY VISITOR OPTIONS - ARRAY OF SCREENS?
            // SIMPLIFY TO HOME SCREEN?
            VisitorCommands visitorScreen = new VisitorCommands(new String[]{"Display animals", "Display pens", "Exit"});

            int userSelection = visitorScreen.getUserSelection();

            if (userSelection == 1) {
                visitorScreen.printAnimals(zoo.getAnimals());

            } else if (userSelection == 2) {
                zoo.getPens().forEach(pen -> visitorScreen.printMessage(pen.getName()));


            } else {
                System.out.println("Quiting");
                isRunning = false;
            }

        }


    }
}
