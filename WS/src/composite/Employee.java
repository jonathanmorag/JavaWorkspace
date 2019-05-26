package composite;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Employee {
	String name;
	int age;
	static Set<Employee> empsPool = new LinkedHashSet<>();

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public abstract void work();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee)obj;
		return name.equals(e.name) && age == e.age &&
				e.getClass().getName().equals(this.getClass().getName());
	}
	
	@Override
	public String toString() {
		return "Name: "+name+"\t\tAge: "+age;
	}
	
	
	@Override
	public int hashCode() {
		return (name+age).hashCode();
	}
	public static void main(String[] args) {
		Employee e1 = new Engineer("jon", 25);
		Employee e2 = new Architect("jon", 25);
		System.out.println(e1.equals(e2));   // should be false
	}
	
}
