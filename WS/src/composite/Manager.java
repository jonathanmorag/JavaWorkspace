package composite;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	
	public List<Employee> employees;
	
	public Manager(String name, int age) {  
		super(name, age);
		employees = new ArrayList<>();
	}

	public Manager(String name, int age, List<Employee> employees) {
		super(name, age);
		this.employees = employees;
	}
 
	public List<Employee> getEmployees() { 
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	public void addEmployee(Employee e) throws Exception  {
		empsPool.add(this);
		if(!empsPool.contains(e)) {
			employees.add(e);
			empsPool.add(e);
		}
		else 
			throw new Exception("Couldn't add employee because of cicrle");
	}
	
	@Override
	public void work() {
		System.out.println(name + " is Managing...");
		employees.forEach(e -> e.work());
 
	}
}  
