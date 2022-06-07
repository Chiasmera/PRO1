package Opgave3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\Opgave2.txt");

        ArrayList<Integer> intList = new ArrayList<>();

        try (Scanner in = new Scanner(inputFile)) {
            while (in.hasNextLine()) {
                try
                {
                    intList.add(0,Integer.parseInt(in.nextLine()));
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

        for (Integer i : intList) {
            System.out.println(i);
        }

    }
}