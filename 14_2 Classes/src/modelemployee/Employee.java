package modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String firstName;
	private String lastName;
	private boolean trainee;
	private int age;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputFirstName, String inputLastName, int initialAge) {
		firstName = inputFirstName;
		lastName = inputLastName;
		age = initialAge;
		trainee = true;
	}

	/*
	 * Den ansattes fornavn kan ændres ved kald af setFirstName metoden
	 */
	public void setFirstName(String inputName) {
		firstName = inputName;
	}

	/*
	 * Den ansattes efternavnnavn kan ændres ved kald af setlastName metoden
	 */
	public void setLastName(String inputName) {
		lastName = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes fornavn, ved at kalde metoden getFirstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * Man kan få oplyst den ansattes efternavn, ved at kalde metoden getLastName
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Fornavn " + firstName);
		System.out.println("Efternavn "+lastName);
		System.out.println("Age: "+age);
		System.out.println("Trainee " + trainee);
		System.out.println();
	}

	//Sets age of the employee
	public void setage(int newAge) {
		age = newAge;
	}

	//Returns the age of the employee
	public int getAge() {
		return age;
	}

	//Adds one to the age of the employee
	public void birthday () {
		age = age+1;
	}
}
