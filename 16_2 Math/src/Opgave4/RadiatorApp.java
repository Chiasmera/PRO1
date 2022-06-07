package Opgave4;

public class RadiatorApp {
    public static void main(String[] args) {
        Radiator radiator1 = new Radiator();
        Radiator radiator2 = new Radiator(22);

        radiator1.skruOp(2);
        radiator2.skruNed(3);

        System.out.println(radiator1.temperature);
        System.out.println(radiator2.temperature);
    }
}
