import java.util.Scanner;

public class ThreadTest {

	static boolean stop = false;

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("Thread started with ID "+ Thread.currentThread().getId());
			while (!stop) {
				System.out.println("Working");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ignored) {}
			}
			System.out.println("Thread ID "+ Thread.currentThread().getId()+" has stopped.");
		});

		Scanner sc = new Scanner(System.in);

		t.start();

		while(!sc.nextLine().equals("stop")) {}
				stop = true;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.close();

		System.out.println("done");
	}
}
