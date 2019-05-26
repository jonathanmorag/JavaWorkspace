import java.util.Observable;
import java.util.Scanner;

public class Event extends Observable implements Runnable {

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		String response;
		while (!(response = in.next()).equals("end")) {
			setChanged();
			notifyObservers(response);
		}
		in.close();
		System.out.println("done");

	}

	public static void main(String[] args) {
		System.out.print("Enter Text >> ");
		Event eventSource = new Event();

		eventSource.addObserver((o, arg) -> {
			System.out.println("Received response: " + arg);
			System.out.print("Enter Text >> ");
		});

		new Thread(eventSource).start();
	}
}
