package modelchild;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(0, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old

		Instutition børnehave = new Instutition("Magueritten", "Onsholtvej 44A");

		System.out.println("Et barn på " + c1.getAge());

		System.out.println("Print største vægtforøgelse");
		System.out.println(c1.getIncrease());

		børnehave.addChild(c1);
		børnehave.addChild(c2);

		System.out.println(børnehave.numberOfGirls());
		System.out.println(børnehave.averageAge());
	}

}
