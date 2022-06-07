package Opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\Keyboard_Input.txt");
        try (Scanner in = new Scanner(System.in); PrintWriter outFile = new PrintWriter(file)) {

            System.out.println("Begin inputting positive integers now. End with \"-1\"");
            boolean inputOpen = true;
            while (inputOpen) {
                int inputNum = in.nextInt();
                if (inputNum == -1) {
                    inputOpen = false;
                } else if (inputNum > 0) {
                    outFile.println(inputNum);
                    System.out.println(inputNum + " has been written to file. Input next number or end with \"-1\"");
                }
            }
            System.out.println();
            System.out.println("All of your input has been written to file. Thank you, come again!");

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Cannot find file. Check path.");

        } catch (InputMismatchException exception) {
            throw new RuntimeException("Input must be a positive integer");
        }

    }
}
