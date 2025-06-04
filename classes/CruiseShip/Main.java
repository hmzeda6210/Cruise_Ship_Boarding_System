import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        
        /* Creating the array of Cabins */
        Cabin cabins[] = new Cabin[12];

        /* Waiting list */
        ArrayList waitingList = new ArrayList();

        /* Initialising every cabin */
        for (int i = 0; i < 12; i++) {
            cabins[i] = new Cabin();
        }

        /* Declaring the variabile for the user's selection */
        String selection = "";

        System.out.println("\nWELCOME TO THE BOARDING SYSTEM!");

        /* Creating a scanner */
        Scanner kb = new Scanner(System.in);

        /* Loop until user presses "Q" */
        while (!selection.equals("Q")) {

            /* Printing the menu */
            System.out.println("\nSelect a voice from the menu:");
            System.out.println(" A: Add customer\n V: View all cabins\n E: Display empty cabins\n D: Delete customer from cabin");
            System.out.println(" F: Find cabin form customer name\n S: Store program data into file\n L: Load program data form a file");
            System.out.println(" O: View passengers ordered in alphabetically by name\n T: View expenses by name or total expenses");
            System.out.println(" Q: Exit");

            /* Reading the user option */
            System.out.print("\nEnter your option: ");
            selection = kb.next();

            /* Analising all cases */
            if (selection.equals("A")) {
                Main.add(cabins, waitingList, kb);
            }
            else if(selection.equals("V")) {
                Main.view(cabins);
            }
            else if(selection.equals("E")) {
                Main.displayEmptyCabins(cabins);
            }
            else if(selection.equals("D")) {
                Main.deletePassenger(cabins, waitingList, kb);
            }
            else if(selection.equals("F")) {
                Main.find(cabins, kb);
            }
            else if(selection.equals("T")) {
                Main.showExpenses(cabins, kb);
            }
            else if (selection.equals("Q")) {
                Main.end();
            }
        }
    }

    

    /* Method for the voice menu A */
    public static void add(Cabin[] cabins, ArrayList waitingList, Scanner kb) {
        /* Insert Customer data */
        System.out.print("\nInsert first name: ");
        String name = kb.next();
        System.out.print("Insert surname: ");
        String surname = kb.next();
        System.out.print("Expenses: ");
        int expenses = kb.nextInt();
        Passenger p = new Passenger(name, surname, expenses);
        /* Selecting cabin */
        System.out.print("Enter a preference for the cabin (if it is full, another cabin will be assigned): ");
        int n = kb.nextInt();
        /* Calling the method */
        if (!cabins[n-1].addPassenger(p)) {
            System.out.println("Cabin #" + n + " is full ...");
            boolean added = false;
            int i = 0;
            while (i < 12 && !added) {
                added = cabins[i].addPassenger(p);
                i++;
            }
            if (added) {
                System.out.println("Passenger added to cabin #" + (i));
            }
            else {
                waitingList.add(p);
                System.out.println("All cabins are full... added to the waiting list");
            }
        }
    }

    /* Method for V */
    public static void view(Cabin[] cabins) {
        for (int i = 0; i < 12; i++) {
            System.out.println("\nCABIN " + (i+1) + ":\n" + cabins[i].toString());
        }
    }

    /* Method for E */
    public static void displayEmptyCabins(Cabin[] cabins) {
        System.out.print("\nList of empty cabins: ");
        for (int i = 0; i < 12; i++) {
            if (cabins[i].getIsEmpty()) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println("");
    }

    /* Method for D */
    public static void deletePassenger(Cabin[] cabins, ArrayList waitingList, Scanner kb) {
        /* Insert Customer data */
        System.out.print("\nInsert first name: ");
        String name = kb.next();
        System.out.print("Insert surname: ");
        String surname = kb.next();
        /* Selecting cabin */
        System.out.print("Enter a cabin: ");
        int n = kb.nextInt();
        /* Calling the method */
        if (cabins[n-1].deletePassenger(name, surname) && waitingList.size() > 0) {
            /* Getting in the cabin the longest waiting customer */
            System.out.println("Adding form the waiting list:");
            Passenger p = (Passenger) waitingList.get(0);
            cabins[n-1].addPassenger(p);
        }
    }

    /* Method for F */
    public static void find(Cabin[] cabins, Scanner kb) {
        /* Insert Customer data */
        System.out.print("\nInsert first name: ");
        String name = kb.next();
        System.out.print("Insert surname: ");
        String surname = kb.next();
        int i = 0;
        while (i < 12 && !cabins[i].findPassenger(name, surname)) {
            i++;
        }
        if (i == 12) {
            System.out.println("Passenger not found!");
        }
        else {
            System.out.println("Passenger " + name + " " + surname + " found at cabin " + (i+1));
        }
    }

    

    

    /* Method for T */
    public static void showExpenses(Cabin cabins[], Scanner kb) {
        /* Asks user which option */
        System.out.print("Insert NAME to view expenses by name or TOTAL to see total expenses: ");
        String selection2 = kb.next();
        if (selection2.equals("NAME")) {
            /* Selecting cabin */
            System.out.print("Enter a cabin: ");
            int n = kb.nextInt();
            /* Insert Customer data */
            System.out.print("Insert first name: ");
            String name = kb.next();
            System.out.print("Insert surname: ");
            String surname = kb.next();
            /* Calling the method */
            int expenses = cabins[n-1].getExpenses(name, surname);
            if (expenses == -1) {
                System.out.println("Passenger not found!");
            }
            else {
                System.out.println("Expenses for passenger " + name + " " + surname + " : " + expenses);
            }
        }
        else if (selection2.equals("TOTAL")) {
            int total = 0;
            for (int i = 0; i < 12; i++) {
                total = total + cabins[i].getTotalExpenses();
            }
            System.out.println("Total expenses of the cruise ship: " + total);
        }
        else {
            System.out.println("Bad input...");
        }
    }

    

    /* Method for Q */
    public static void end() {
        System.out.print("\nPROGRAM IS ENDING ");
        
    }
}