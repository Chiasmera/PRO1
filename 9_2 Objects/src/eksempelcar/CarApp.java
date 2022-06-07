package eksempelcar;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());
		System.out.println(myCar.getKm());


		Car newShinyCar = new Car("Skoda citygo", "Black");
		System.out.println(newShinyCar.getBrand());
		System.out.println(newShinyCar.getColor());
		newShinyCar.setRegistrationNumber("BK 95 661");
		newShinyCar.setKm(150000);

		System.out.println("+-------------------------+");
		System.out.println("|"+ newShinyCar.getColor() + newShinyCar.getBrand() + "        |");
		System.out.println("|"+newShinyCar.getRegistrationNumber() + " har kørt " + newShinyCar.getKm() + " |");
		System.out.println("+-------------------------+");


	}

}
