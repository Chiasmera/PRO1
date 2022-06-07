package Opgave7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave7 {
    public static void main(String[] args) {
        System.out.println(Opgave7.findPerson("Olsen", "C:\\Users\\juliu\\IdeaProjects\\PRO1\\18_5\\Opgave7.txt"));


    }

    public static String findPerson(String lastName, String path) {
        File file = new File(path);

        try (Scanner in = new Scanner(file) ) {

            String foundname = "";

            while (in.hasNextLine()) {
                String current = in.nextLine();

                int fullStart = 0;
                while (Character.isDigit(current.charAt(fullStart)) || Character.isWhitespace(current.charAt(fullStart))) {
                    fullStart++;
                }

                String fullName = current.substring(fullStart);
                int i = 0;
                while (!Character.isWhitespace(fullName.charAt(i))) {
                    i++;
                }

                String currentLastName = fullName.substring(i).trim();
                if (currentLastName.equals(lastName)) {
                    foundname = fullName;
                }

            }

            return foundname;

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File is not found. Check path.");
        }
    }
}
