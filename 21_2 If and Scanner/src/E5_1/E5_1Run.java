package E5_1;

import java.util.Scanner;

public class E5_1Run {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which number do you wonder if it is positive or not?");
        int inputNumber = scan.nextInt();

        E5_1 opgave1 = new E5_1();

        opgave1.checkIntPositive(inputNumber);

        scan.close();
    }
}
