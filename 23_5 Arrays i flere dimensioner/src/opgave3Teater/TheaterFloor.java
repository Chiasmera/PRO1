package opgave3Teater;

import java.sql.SQLOutput;

public class TheaterFloor {
	int[][] seats = { 	{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
						{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
						{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
						{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
						{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
						{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
						{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
						{ 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
						{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
	 * returneres. Der returneres 0 hvis pladsen er optaget.
	 *
	 * @param row Rækken hvor pladsen er placeret
	 * @param seat Kolonnen hvor pladsen er placeret
	 * @return Prisen på den pågældende plads
	 */

	public int buySeat(int row, int seat) {
		int price;
		price = seats[row][seat];
		seats[row][seat] = 0;
		return price;
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 * @return returnerer prisen for pladsen, eller 0 hvis der ikke er pladser til den pågældende pris
	 */
	public int buySeat(int price) {
		int row = 0;
		int col = 0;
		int foundPrice = 0;
		boolean found = false;
		while (row < seats.length && !found) {
			while (col < seats[row].length && !found) {
				if (seats[row][col] == price) {
					foundPrice = buySeat(row, col);
					found = true;
				} else {
					col++;
				}
			}
			row++;
		}
		return foundPrice;
	}

	public void printTheaterFloor() {

		System.out.print("Sæde\t:");
		for (int i = 0; i < seats[0].length; i++) {
			System.out.print("\t"+(i+1));
		}
		System.out.println();
		System.out.println("---------------------------------------------------------");

		for (int i = 0; i < seats.length; i++) {
			System.out.print("Række "+ (1+i) + "\t:");
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print("\t" + seats[i][j]);
				if (j < seats[i].length-1) {
					System.out.print(",");
				}
			}

			System.out.println();
		}
	}
}
