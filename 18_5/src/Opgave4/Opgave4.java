package Opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {

        System.out.println(Opgave4.linFileSearch("C:\\Users\\juliu\\IdeaProjects\\PRO1\\18_5\\Opgave4.txt", 4203));
        System.out.println(Opgave4.linFileSearch("C:\\Users\\juliu\\IdeaProjects\\PRO1\\18_5\\Opgave4.txt", 12));

    }

    public static boolean linFileSearch(String fileName, int target) {
        File file = new File(fileName);

        boolean found = false;
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextInt() && !found) {
                if (in.nextInt() == target) {
                    found = true;
                }
            }

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found. Check path");
        }

        return found;
    }


}
