package Ex2selfExercise;

import java.util.HashMap;

public class WorkersFactory {

	private interface Creator {
		public Worker create();
	}

	HashMap<String, Creator> factory;

	public WorkersFactory() {
		factory = new HashMap<>();

		factory.put("programmer", () -> new Programmer());
		factory.put("designer", () -> new Designer());
		factory.put("manager", () -> new Manager());
	}

	public Worker createWorker(String type) {
		Creator c = factory.get(type);
		if (c != null)
			return c.create();
		return null;
	}

	public static void main(String[] args) {
		WorkersFactory wf = new WorkersFactory();
		wf.createWorker("designer").work();
		wf.createWorker("manager").work();
	}

}
