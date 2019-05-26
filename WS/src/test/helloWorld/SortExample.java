package test.helloWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortExample {

	public static void main(String[] args) {

		List<Worker> workers = new ArrayList<>();
		workers.add(new Worker("Jonathan", 25, 3000));
		workers.add(new Worker("Bar", 17, 4500));
		workers.add(new Worker("Dan", 30, 2030));
		workers.add(new Worker("Amit", 22, 7000));
		workers.add(new Worker("Tom", 19, 3000));

		Scanner rd = new Scanner(System.in);
		System.out.println("For AgeCompare press 1, NameCompare press 2, SalaryCompare press 3");
		int n = rd.nextInt();
		switch (n) {
		case 1:
			Collections.sort(workers, (w1, w2) -> w1.getAge() - w2.getAge());
			break;
		case 2:
			Collections.sort(workers, (w1, w2) -> w1.getName().compareTo(w2.getName()));
			break;
		case 3:
			Collections.sort(workers, (w1, w2) -> Double.compare(w1.getSalary(), w2.getSalary()));
		}

		rd.close();

		workers.forEach(w -> System.out.println(w));

	}

}
