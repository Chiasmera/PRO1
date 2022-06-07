public class TestMain {

    public static void main(String[] args) {

        //Test for at se om man kan bruge "d" for at markere en double type
        double resultat = 8d / 3d;
        System.out.println(resultat);

        //hvad er default værdi af en char? Nej
        //char test;
        //System.out.println(test);

        //Kan man printe uinitialized værdi af en int? nej
        //int test1;
        //System.out.println(test1);

        //test om compiler lægger tal sammen, når de står med strings. Svar: kun indtil den møder en string, derefter behandler den tal som strings
        System.out.println(3+2+"hej");
        System.out.println(3+"hej"+2);
        System.out.println("hej"+3+2);
        System.out.println(2+"hej"+3+7);
    }
}
