package child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		Child c3 = new Child(32, true);// boy 32 years old

		System.out.print("Et barn på " + c1.getAge()+" ");
		System.out.print("med kønnet " + c1.gender()+" ");
		System.out.print("går i "+c1.institution()+" ");
		System.out.println("og skal på hold: "+c1.team());

		System.out.print("Et andet barn på " + c2.getAge()+" ");
		System.out.print("med kønnet " + c2.gender()+" ");
		System.out.print("går i "+c2.institution()+" ");
		System.out.println("og skal på hold: "+c2.team());

		System.out.print("Et tredje barn på " + c3.getAge()+" ");
		System.out.print("med kønnet " + c3.gender()+" ");
		System.out.print("går i "+c3.institution()+" ");
		System.out.println("og skal på hold: "+c3.team());

	}

}
