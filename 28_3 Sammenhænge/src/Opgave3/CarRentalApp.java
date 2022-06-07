package Opgave3;

import java.time.LocalDate;

public class CarRentalApp {
    public static void main(String[] args) {
        Car c1 = new Car("BK66195",2017);
        c1.setDayPrice(100);
        Car c2 = new Car("GH23291",1990);
        c2.setDayPrice(300);
        Car c3 = new Car("KS39573",2013);
        c3.setDayPrice(150);
        Car c4 = new Car("OG27642",2020);
        c4.setDayPrice(200);
        Car c5 = new Car("OF94037",1999);
        c5.setDayPrice(50);

        Rental r1 = new Rental(1,3, "28/3-2020");
        r1.addCar(c1);
        r1.addCar(c3);
        r1.addCar(c5);

        Rental r2 = new Rental(2,7, "14/4-2020");
        r2.addCar(c4);
        r2.addCar(c5);

        System.out.println(r1.getPrice());
        System.out.println(r2.getPrice());
    }
}
