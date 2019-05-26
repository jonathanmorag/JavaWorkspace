package composite;

public class Architect extends Employee {

	public Architect(String name, int age) {
		super(name, age);
	}

	public void work() {
		System.out.println(this.getName() + " is Creating...");
	}

}