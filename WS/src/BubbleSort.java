
import java.util.Comparator;


import test.helloWorld.Worker;

public class BubbleSort<T> {

	Comparator<T> comparator;

	public BubbleSort(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void sort(T[] arr) {
		T temp = null;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (comparator.compare(arr[j - 1], arr[j]) > 0) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}

	public static void main(String[] args) {
//		Integer[] arr = { 9, 8, 7, 5, 3 };
//		new BubbleSort<Integer>((o1, o2) -> o1 - o2).sort(arr);
//		for (int n : arr)
//			System.out.print(n + ", ");

		Worker[] workers = new Worker[5];
		workers[0] = new Worker("Jonathan", 25, 3000);
		workers[1] = new Worker("Bar", 17, 4500);
		workers[2] = new Worker("Dan", 30, 2030);
		workers[3] = new Worker("Amit", 22, 7000);
		workers[4] = new Worker("Tom", 19, 3000);
		
		//new BubbleSort<Worker>((w1, w2) -> w1.getName().compareTo(w2.getName())).sort(workers);
		new BubbleSort<Worker>((w1, w2) -> w1.getAge() - w2.getAge()).sort(workers);
		for (Worker w : workers)
			System.out.println(w);
	}

}
