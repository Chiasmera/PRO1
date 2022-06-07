package Opgave6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilUtil {


    public int max(String filename) throws IOException {
        File inputFile = new File(filename);
        int currentMax = -1;
        Scanner in = new Scanner(inputFile);
        while (in.hasNextInt()) {
            int currentInt = in.nextInt();
            if (currentInt > currentMax) {
                currentMax = currentInt;
            }
        }
        in.close();
        return currentMax;

    }

    public int min(String fileName) throws IOException {
        File inputFile = new File(fileName);
        Scanner in = new Scanner(inputFile);
        int curentMin = in.nextInt();
        while (in.hasNextInt()) {
            int currentInt = in.nextInt();
            if (currentInt < curentMin) {
                curentMin = currentInt;
            }
        }
        in.close();
        return curentMin;
    }

    public double gennemsnit(String fileName) throws IOException {
        File inputFile = new File(fileName);
        double sum = 0;
        int counter = 0;
        double result;
        Scanner in = new Scanner(inputFile);
        while (in.hasNextInt()) {
            sum += in.nextInt();
            counter++;
        }
        if (counter != 0) {
            result = sum / counter;
        } else {
            result = -1;
        }
        in.close();
        return result;
    }
}
