package Ex2selfExercise;

import java.util.Scanner;

public class SwitchWorkers {

	public static void main(String[] args) {
		System.out.println("How many workers?");
		Scanner rd = new Scanner(System.in);
		int n = rd.nextInt();
		Worker [] workers = new Worker[n];
		int in;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter 1 for Programmer, 2 for Designer or 3 for Manager");
			in = rd.nextInt();
			switch(in) {
			case 1:
				workers[i] = new Programmer();
				break;
			case 2:
				workers[i] = new Designer();
				break;
			case 3:
				workers[i] = new Manager();
				break;
			}
		 
		}
		rd.close();
		for (Worker w : workers)
			w.work();
		
	}

}
