package opgave3Teater;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();

		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Input number matching the function you wish to accomplish:");
			System.out.println("1 : Buy seat by location");
			System.out.println("2 : Buy seat by price");
			System.out.println("3 : Show seats");

			int n = in.nextInt();
			if (n == 1) {
				System.out.println("Please choose a row number");
				int row = in.nextInt();
				System.out.println("Please choose a seat number");
				int col = in.nextInt();

				int result = theater.buySeat(row, col);

				if (result == 0) {
					System.out.println("this seat is already occupied. Please restart");
				} else {
					System.out.println("You have bought seat "+row+","+col+". Your price is: "+result);
				}

			} else if (n == 2) {
				System.out.println("Please input a price");
				int price = in.nextInt();

				int result = theater.buySeat(price);
				if (result == 0) {
					System.out.println("No seat was found with this price. Please restart");
				} else {
					System.out.println("You have bought a seat for the amount of " + price + ". Thank you come again!");
				}

			} else if (n == 3) {

				theater.printTheaterFloor();

			} else {
				System.out.println("i did not understand. Please restart");
			}


		} catch (NoSuchElementException exception) {
			throw new RuntimeException("Something went wrong with the scanner");
		}


	}
}
