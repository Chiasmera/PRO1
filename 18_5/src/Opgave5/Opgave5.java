package Opgave5;

import com.sun.source.tree.CatchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {

        Opgave5.fletAlleHeltal("C:\\Users\\juliu\\IdeaProjects\\PRO1\\18_5\\Opgave5_1.txt", "C:\\Users\\juliu\\IdeaProjects\\PRO1\\18_5\\Opgave5_2.txt", "C:\\Users\\juliu\\IdeaProjects\\PRO1\\18_5\\Opgave6_3.txt");

    }

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal fra fileName1 og fileName2 (MAX_VALUE skal ikke i
     * resultatet)
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy) {
        File input1 = new File(fileName1);
        File input2 = new File(fileName2);
        File output = new File(fileNameNy);

        try (Scanner in1 = new Scanner(input1); Scanner in2 = new Scanner(input2); PrintWriter out = new PrintWriter(output)) {
            int hold1 = in1.nextInt();
            int hold2 = in2.nextInt();
            while (in1.hasNextInt() && in2.hasNextInt()) {
                if (hold1 <= hold2) {
                    out.println(hold1);
                    hold1 = in1.nextInt();
                } else {
                    out.println(hold2);
                    hold2 = in2.nextInt();
                }
            }

            if (hold1 <= hold2) {
                out.println(hold1);
                out.println(hold2);
            } else {
                out.println(hold2);
                out.println(hold1);
            }

            while (in1.hasNextInt()) {
                out.println(in1.nextInt());
            }

            while (in2.hasNextInt()) {
                out.println(in2.nextInt());
            }

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("One of the files has not been found. Check if the paths are correct.");
        }
    }
}
