package Ex7;

public class Q2 {

	public static void a() {
		A a = new A();

		while (A.r < 10)
			a.m1();
		a.m2();
		while (A.v < 10) {
			Thread t1 = new Thread(() -> a.m3());
			Thread t2 = new Thread(() -> a.m4());
			Thread t3 = new Thread(() -> a.m5());
			t1.start();
			t2.start();
			t3.start();

			try {
				t1.join();
				t2.join();
				t3.join();
			} catch (InterruptedException e) { e.printStackTrace(); }
			a.m2();
		}

	}

	public static void b() {
		A a1 = new A();
		A a2 = new A();
		Thread t = new Thread(() -> a1.m1());
		t.start();
		a2.m1();
		try {
			t.join();
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		for (int i = 0; i < 5; i++)
			a1.m2();
		a2.m3();

	}
}
