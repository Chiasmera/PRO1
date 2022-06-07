package child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		if (age == 0) {
			return "Home";
		} else if (age <= 2) {
			return "Nursery";
		} else if (age <= 5) {
			return "Kindergarten";
		} else if (age <= 16) {
			return "School";
		} else {
			return "Out of school";
		}
	}

	public String gender() {
		if (boy) {
			return "Boy";
		} else {
			return "Girl";
		}
	}

	public String team() {
		if (boy && age < 8) {
			return "Young Boys";
		} else if (boy) {
			return "Cool boy";
		} else if (age < 8) {
			return "Tumbling girls";
		} else {
			return "Springy girls";
		}
	}

}
