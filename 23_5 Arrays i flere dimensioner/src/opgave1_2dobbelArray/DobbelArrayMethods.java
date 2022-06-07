package opgave1_2dobbelArray;

/**
 * @author mad
 *
 */
public class DobbelArrayMethods {

	public void udskrivArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "  ");
			}
			System.out.println();
		}
	}

	// Opgave 1.1

	/**
	 * Returnerer værdien på angivede plads i et dobbeltarray
	 * @param numbers dobbeltarrayet
	 * @param row rækken værdien findes i
	 * @param col kolonnen værdien findes i
	 * @return værdien på angivede plads
	 */
	public  int getValueAt(int[][] numbers, int row, int col){
		return numbers[row][col];
	}

	// Opgave 1.2

	/**
	 * Insætter en værdi på en bestemt plads i et dobbeltarray
	 * @param numbers arrayet
	 * @param row rækken i arrayet
	 * @param col kolonnen i arrayet
	 * @param value værdien som skal indsættes
	 */
	public  void setValueAt(int[][] numbers, int row, int col, int value){
		numbers[row][col] = value;
	}

	// Opgave 1.3

	/**
	 * Returnerer summen af en hel række
	 * @param numbers et dobbeltarray
	 * @param row rækken som skal summeres
	 * @return summen af rækken
	 */
	public  int sumRow(int[][] numbers, int row) {
		int sum = 0;
		for (int i = 0; i < numbers[row].length; i++) {
			sum += numbers[row][i];
		}
		return sum;
	}

	// Opgave 1.4

	/**
	 * Returnerer summen af en kolonne i et dobbelarray
	 * @param numbers et dobbeltarray
	 * @param col kolonnen der skal summeres
	 * @return
	 */
	public  int sumCol(int[][] numbers, int col) {
		int sum = 0;
		for (int row = 0; row < numbers.length; row++) {
			sum += numbers[row][col];
		}
		return sum;
	}

	// Opgave 1.5

	/**
	 * Returnerer summen af alle tal i et dobbeltarray
	 * @param numbers et dobbeltarray
	 * @return summen af alle værdier i arrayet
	 */
	public  int sum(int[][] numbers) {
		int sum = 0;
		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers[row].length; col++) {
				sum += numbers[row][col];
			}
		}
		return sum;
	}

}
