package composite;


public class Engineer extends Employee {
	
	public Engineer(String name, int age) {
		super(name, age);
	}
	
	public void work() {
		System.out.println(this.name+" is Planning...");
	}
}
