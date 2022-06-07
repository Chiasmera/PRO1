package Opgave1.Opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\Opgave2.txt");

        try (Scanner in = new Scanner(inputFile)) {
            while (in.hasNextLine()) {
                try
                {
                    int doubleInput = Integer.parseInt(in.nextLine());
                    doubleInput *= 2;
                    System.out.println(doubleInput);
                }
                catch (NumberFormatException exception)
                {
                    System.out.println("Next line in file is not an integer");
                }
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File not found. Check the file path.");
        }


    }
}
