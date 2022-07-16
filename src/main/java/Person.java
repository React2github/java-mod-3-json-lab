public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public Person(String firstName, String lastName, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    // DEFAULT CONSTRUCTOR
    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
