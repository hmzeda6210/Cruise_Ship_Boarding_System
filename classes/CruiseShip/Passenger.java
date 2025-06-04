public class Passenger {

    /* Attributes */
    private String firstName;
    private String surname;
    private int expenses;

    /* Constructor */
    public Passenger(String firstName, String surname, int expenses) {
        this.firstName = firstName;
        this.surname = surname;
        this.expenses = expenses;
    }

    /* Method to increase expenses, not requested by project specification */
    public void increaseExpenses(int amount) {
        expenses = expenses + amount;
    }

    /* Getters methods */
    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getExpenses() {
        return expenses;
    }

    /* Overriding of toString() method */
    public String toString() {
        String s = "Name: " + this.firstName + " ; Surname: " + this.surname + " ; Expenses: " + this.expenses;
        return s;
    }

    public String toStringSimple() {
        String s = surname + " " + firstName;
        return s;
    }
}