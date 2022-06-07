package Opgave2;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Product banan = new Product(1,"Banan", 5);
        Product aeble = new Product(2,"Æble",3);
        Product citron = new Product(3,"Citron", 4);
        Product kartoffel = new Product(4,"Kartoffel",2);
        Product gulerod = new Product(5, "Gulerod",3);

        PercentDiscount pd1 = new PercentDiscount(15);
        FixedDiscount fd1 = new FixedDiscount(250, 1000);

        Customer julius = new Customer("Julius", LocalDate.of(1990,5,3), pd1);
        Customer julemanden = new Customer("Julemanden", LocalDate.of(1165,12,24),fd1);

        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);
        Order o5 = new Order(5);
        Order o6 = new Order(6);

        julius.addOrder(o1);
        o1.createOrderLine(30,aeble);
        o1.createOrderLine(10,citron);

        julius.addOrder(o2);
        o2.createOrderLine(500,citron);
        o2.createOrderLine(20,kartoffel);

        julius.addOrder(o3);
        o3.createOrderLine(20,kartoffel);
        o3.createOrderLine(40,aeble);

        julius.addOrder(o4);
        o4.createOrderLine(60,gulerod);
        o4.createOrderLine(10,banan);

        julemanden.addOrder(o5);
        o5.createOrderLine(500,banan);
        o5.createOrderLine(1000,citron);

        julemanden.addOrder(o6);
        o6.createOrderLine(70,aeble);
        o6.createOrderLine(20,citron);


        System.out.println("Julius køber for: "+ julius.totalBuy());
        System.out.println("Efter rabat bliver det: "+julius.totalBuyWithDiscount());
        System.out.println();
        System.out.println("Julemanden køber for: "+ julemanden.totalBuy());
        System.out.println("Efter rabat bliver det: "+julemanden.totalBuyWithDiscount());
        System.out.println();
    }
}
