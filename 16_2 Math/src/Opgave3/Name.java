package Opgave3;

public class Name {
    //fields
    String firstName;
    String middleName;
    String lastName;

    //Constructor
    public Name (String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    //Methods
    public String getFirstName () {
        return firstName;
    }

    public String getMiddleName () {
        return middleName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName (String middleName) {
        this.middleName = middleName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getInit () {
        char i1 = firstName.charAt(0);
        char i2 = middleName.charAt(0);
        char i3 = lastName.charAt(0);
        String init = Character.toString(i1) + Character.toString(i2)+Character.toString(i3);
        //String init = ""+i1 + ""+i2 + ""+i3;
        return init;
    }

    public String getUsername () {
        String firstTwo = firstName.substring(0,2).toUpperCase();
        int middleLength = middleName.length();
        String lastTwo = lastName.substring((lastName.length()-2),(lastName.length())).toLowerCase();
        return firstTwo+middleLength+lastTwo;


    }
}
