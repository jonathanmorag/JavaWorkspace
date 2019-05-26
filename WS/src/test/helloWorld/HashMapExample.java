package test.helloWorld;

import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		
		HashMap<String, Worker> hm = new HashMap<>();
		hm.put("Jonathan", new Worker("Jonathan", 25, 3000));
        hm.put("Bar", new Worker("Bar", 17, 4500));
        hm.put("Dan", new Worker("Dan", 30, 2030));
        hm.put("Amit", new Worker("Amit", 22, 7000));
        hm.put("Tom", new Worker("Tom", 19, 3000));
        hm.put("Shalom", new Worker("Shalom", 21, 9010));
        
      //   hm.entrySet().forEach(e -> System.out.println(e.getValue()));
        hm.values().forEach(v -> System.out.println(v));
	}

}