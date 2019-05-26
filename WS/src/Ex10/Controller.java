package Ex10;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Controller {

	public interface Command{
		int getID();
		void execute();
	}
	
	PriorityQueue<Measurable> queue;
	
	Map<Integer, Measurable> map = new HashMap<>();
	
	public Controller() {
		queue = new PriorityQueue<>(new Comparator<Measurable>() {

			@Override
			public int compare(Measurable m1, Measurable m2) {
				return Long.compare(m1.time, m2.time);
			}
		});
	}
	
	public void insertCommand(Command c){
		Measurable m = map.get(c.getID());
		if(m == null) {
			m = new Measurable(c);
			map.put(c.getID(), m);
		} 
		queue.add(m);
		
	}
	
	public class Measurable {
		long time;
		Command c;
		
		public Measurable(Command c) {
			this.c = c;
		}
				
		public void execute() {
			long current = System.currentTimeMillis();
			c.execute();
			time = System.currentTimeMillis() - current;
		}
	}
	
	public void executeOne(){
		if(!queue.isEmpty())
			queue.poll().execute();
	}
	
	public void executeAll(){
		while(!queue.isEmpty())
			queue.poll().execute();
	}
}
