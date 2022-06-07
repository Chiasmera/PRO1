package soegningelevopgaver;

import java.util.Arrays;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		System.out.println();

		int[] testArray = {7,56,34,3,7,14,3};
		System.out.println("Testarray: " + Arrays.toString(testArray));
		System.out.println("Hvad er det første tal mellem 10 & 15? " + s.find10Til15(testArray));
		System.out.println();

		System.out.println("Er der to ens tal ved siden af hinanden? " + s.findToEns(testArray));
		int[] testArray2 = {2, 45, 12, 78, 23, 23, 4, 8, 2, 15, 80, 5};
		System.out.println("Nyt testarray: " + Arrays.toString(testArray2));
		System.out.println("Er der to ens tal ved siden af hinanden? " + s.findToEns(testArray2));
		System.out.println();



	}

}
