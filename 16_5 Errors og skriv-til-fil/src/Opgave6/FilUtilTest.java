package Opgave6;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FilUtilTest {
    public static void main(String[] args) {



        FilUtil f1 = new FilUtil();
        try {
            System.out.println("Tester alle metoder på fil 1");
            System.out.println(f1.max("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_1.txt"));
            System.out.println(f1.min("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_1.txt"));
            System.out.println(f1.gennemsnit("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_1.txt"));


            System.out.println("Tester alle metoder på fil 2");
            System.out.println(f1.max("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_2.txt"));
            System.out.println(f1.min("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_2.txt"));
            System.out.println(f1.gennemsnit("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_2.txt"));
        }
        catch (IOException exception) {
            System.out.println("There is an issue with the filename");
        }
    }
}
