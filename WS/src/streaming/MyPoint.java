package streaming;

import java.util.Arrays;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MyPoint extends Point {

	private static final long serialVersionUID = 1L;

	public MyPoint(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	  
	public static void main(String[] args) {

		List<Point> list = new LinkedList<>();
		Random r = new Random();
		
		for (int i = 0; i < 15; i++)
			list.add(new MyPoint(r.nextInt(200) - 100, r.nextInt(200) - 100));
		
		// list.parallelStream().filter(p -> p.getX() > 0).forEach(System.out::println);

		List<String> strings = Arrays.asList("the", "answer", "to");
		int length = strings.parallelStream().map(String::length).reduce(0, (x,y)->x+y);
		System.out.println(length);
	}
}
