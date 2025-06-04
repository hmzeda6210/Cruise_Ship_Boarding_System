import java.util.ArrayList;

public class Cabin {

    /* Attributes */
    private Passenger[] passengers;
    private boolean isEmpty;

    /* Constructor with no parameters */
    public Cabin() {
        passengers = new Passenger[3];
        isEmpty = true;
    }

    /* Method to set the isEmpty attribute automatically */
    public void setEmptiness() {
        boolean empty = true;
        int i = 0;
        while (i < 3) {
            if (passengers[i] != null)
                empty = false;
            i++;
        }

        /* Setting the attribute */
        this.isEmpty = empty;
    }

    /* Method to view if the cabin is full */
    public boolean isFull() {
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            if (passengers[i] == null)
                full = false;
        }
        return full;
    }

    /* Method to add a passenger if the cabin is not full
    returns true if successfully added, false otherwise 
    This method has a Passenger object as parameter, not simply name and surname as Strings*/
    public boolean addPassenger(Passenger p) {
        boolean added = false;
        int i = 0;
        while (!added && i<3) {
            if (passengers[i] == null) {
                /* If one element of the array of passengers is empty
                adding the passenger p to that position of the array */
                passengers[i] = p;
                added = true;
            }
            i++;
        }
        /* Verify if at the end of the cycle passenger p has been added */
        if (added) {
            System.out.println("Passenger [ " + p.toString() + " ] has been added!");
        }

        /* Setting isEmpty attribute */
        this.setEmptiness();

        return added;
    }

    /* Delete passenger from this cabin
    returns true if successfully removed, false otherwise */
    Passenger p = null;
    public boolean deletePassenger(String firstName, String surname) {
        boolean found = false;
        int i = 0;
        while (!found && i < 3) {
            if (firstName.equals(passengers[i].getFirstName()) && surname.equals(passengers[i].getSurname())) {
                found = true;
                p = passengers[i];
                passengers[i] = null;
            }
            i++;
        }

        /* Verify if passenger has been found */
        if (!found) {
            System.out.println("Passenger not found...");
        }
        else {
            System.out.println("Passenger [ " + p.toString() + " ] successfully removed!");
        }

        /* Setting isEmpty attribute */
        this.setEmptiness();

        return found;
    }

    /* Method to find a passenger
    useful for the F voice of menu */
    public boolean findPassenger(String firstName, String surname) {
        boolean found = false;
        int i = 0;
        while (!found && i < 3) {
            if (passengers[i] != null) {
                if (firstName.equals(passengers[i].getFirstName()) && surname.equals(passengers[i].getSurname())) {
                    found = true;
                }
            }
            i++;
        }

        return found;
    }

    /* Method to get a specified passenger
    returns the specified passenger if found, null otherwise */
    public Passenger getPassenger(String firstName, String surname) {
        boolean found = false;
        int i = 0;
        Passenger wanted = null;
        while (!found && i < 3) {
            if (firstName.equals(passengers[i].getFirstName()) && surname.equals(passengers[i].getSurname())) {
                found = true;
                wanted = passengers[i];
            }
            i++;
        }

        return wanted;
    }


    /* Method to get the expenses of a specified passenger
    return -1 if the passenger is not present in the cabin */
    public int getExpenses(String firstName, String surname) {
        int expenses = -1;
        Passenger p = this.getPassenger(firstName, surname);
        if (p != null) {
            expenses = p.getExpenses();
        }

        return expenses;
    }

    /* Method to get the total expenses of all passengers in the cabin */
    public int getTotalExpenses() {
        int total = 0;
        if (!this.isEmpty) {
            for (int i = 0; i < 3; i++) {
                if (passengers[i] != null) {
                    total = total + passengers[i].getExpenses();
                }
            }
        }

        return total;
    }

    /* Overriding toString() method
    prints always a new line at the end */
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            if (passengers[i] != null) {
                s = s + passengers[i].toString() + "\n";
            }
        }

        if (this.isEmpty) {
            s = "";
        }

        return s;
    }

    /* Getters */
    public boolean getIsEmpty() {
        return isEmpty;
    }

}