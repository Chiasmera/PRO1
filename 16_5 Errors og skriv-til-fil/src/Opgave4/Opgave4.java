package Opgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Opgave4 {
    public static void main(String[] args) {
        try (PrintWriter outputFile = new PrintWriter("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\Odd_Numbers.txt")) {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 != 0) {
                    outputFile.println(i);
                }
            }

        } catch (FileNotFoundException exception) {
            System.out.println("File not found. Check the path.");
        }
    }
}
