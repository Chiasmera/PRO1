package E5_7;

import java.util.Scanner;

public class IncreasingRun {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Increasing increasing = new Increasing();

        System.out.println("What is the first number?");
        int inputNumber1 = scan.nextInt();

        System.out.println("What is the second number?");
        int inputNumber2 = scan.nextInt();

        System.out.println("What is the third number?");
        int inputNumber3 = scan.nextInt();

        String result = increasing.IsIncreasing(inputNumber1,inputNumber2,inputNumber3);
        System.out.println("The numbers are "+ result);

        scan.close();
    }
}
