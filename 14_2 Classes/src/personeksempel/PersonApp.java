package personeksempel;

public class PersonApp {
    public static void main(String[] args) {
        Person person1 = new Person("Anders","Høgevej", 37000);
        person1.hireAt("Føtex");
        person1.printPerson();
    }
}
