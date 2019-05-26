package composite;

public class Main {

	public static void main(String[] args) {
		
		Manager a = new Manager("A",35);
		
		Engineer b = new Engineer("B", 50);
		Engineer c = new Engineer("C", 41);
		Manager d = new Manager("D",33);
		
		Engineer e = new Engineer("E", 24);
		Engineer f = new Engineer("F", 22);
		Manager g = new Manager("G",18);
		
		Manager k = new Manager("K", 41);
				
		try {
			a.addEmployee(b); a.addEmployee(c); a.addEmployee(d);
			d.addEmployee(e); d.addEmployee(f); d.addEmployee(g);
			g.addEmployee(k); // g.addEmployee(b);
			
		} catch (Exception exception) { exception.printStackTrace(); return; } 
		
		// a.work();
		double avg = Employee.empsPool.stream().map(Employee::getAge).reduce(0, (x,y)->x+y) / Employee.empsPool.size();
		System.out.println("Age average: "+avg);
		Employee.empsPool.forEach(System.out::println);
		System.out.println("\ndone");
	}

}
  
  
//PECS
//Producer Extends 
//Consumer Super  

  