package Opgave0;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Julemanden",1050);
        Student s1 = new Student("Påskeharen", 1580, "Æglægning");
        Instructor i1 = new Instructor("Gaius Julius Caesar", 80, 50000.99);


        System.out.println(p1);
        System.out.println(s1);
        System.out.println(i1);
    }


}
