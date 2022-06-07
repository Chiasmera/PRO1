package Opgave6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerRead {

	public static void main(String[] args) {
		try {
			File filein = new File("C:\\Users\\juliu\\IdeaProjects\\PRO1\\16_5 Errors og skriv-til-fil\\RandomTalFil_1.txt");
		//	File filein = new File("tal.txt");
			Scanner scan = new Scanner(filein);
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			scan.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
