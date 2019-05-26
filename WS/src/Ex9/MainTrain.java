package Ex9;

import java.util.ArrayList;
import java.util.List;

import Ex9.Q2.*;

public class MainTrain {

	public static void main(String[] args) {
		
		List<Goblin> list = new ArrayList<Goblin>();
		
		// Goblin error=new Goblin(...); // cannot create goblins without the builder
		list.add(new Goblin.GoblinBuilder("zoot", "green").withSize(500).withIq((byte) 40).build());
		list.add(new Goblin.GoblinBuilder("danganesh", "red").withSize(600).build());
		list.add(new Goblin.GoblinBuilder("gilgal", "yellow").withIq((byte) 10).withSize(0).build());
		list.add(new Goblin.GoblinBuilder("zootah", "red").withIq((byte) 100).build());
		
		list.forEach(g -> System.out.println(g+"\n"));
		
		Q2 q2 = new Q2();
		AbstractFactory af = q2.new AbstractFactory1();
		if (!af.createA().get().equals("a1"))
			System.out.println("wrong implementation for AbstractFactory1 createA() (-10)");
		if (!af.createB().get().equals("b1"))
			System.out.println("wrong implementation for AbstractFactory1 createB() (-10)");
		af = q2.new AbstractFactory2();
		if (!af.createA().get().equals("a2"))
			System.out.println("wrong implementation for AbstractFactory2 createA() (-10)");
		if (!af.createB().get().equals("b2"))
			System.out.println("wrong implementation for AbstractFactory2 createB() (-10)");
		
		System.out.println("done");
	}

}
