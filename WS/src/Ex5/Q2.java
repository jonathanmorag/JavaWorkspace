package Ex5;

// import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2 {

	public static interface StringReader {
		String readString();
	}

	public static class MyWordFilter implements StringReader { // Decorator
		
		StringReader sr;

		public MyWordFilter(StringReader sr) {
			this.sr = sr;
		}

		@Override
		public String readString() {
//			Set<String> set = new LinkedHashSet<>(Arrays.asList(sr.readString().split(" ")));
//			return String.join(";", set)+";";
			
			//return String.join(";", new LinkedHashSet<>(Arrays.asList(sr.readString().split(" "))))+";";
			Scanner sc = new Scanner(sr.readString());
			sc.useDelimiter(" ");
			StringBuilder sb = new StringBuilder();
			Set<String> set = new LinkedHashSet<>();
			while(sc.hasNext())
				set.add(sc.next());
			sc.close();
			set.forEach(s -> sb.append(s+";"));
			return sb.toString();
			
		}

	}

	public static interface IntArrayReader {
		int[] readIntArray();
	}

	public static class MyIntArrayToStringReader implements StringReader { // Object Adapter

		IntArrayReader iar;

		public MyIntArrayToStringReader(IntArrayReader iar) {
			this.iar = iar;
		}

		@Override
		public String readString() {
			StringBuilder sb = new StringBuilder();
		    for(int i : iar.readIntArray())
				sb.append(i+" ");
			
			/* String[]strings = new String[iar.readIntArray().length];               Solution #1
			for(int i = 0; i < strings.length; i++)
				strings[i] = String.valueOf(iar.readIntArray()[i]);
			for(String s : strings)
				sb.append(s+" "); */
			
//			Arrays.asList(Arrays.stream(iar.readIntArray()).boxed().toArray(Integer[]::new))    //  Solution #2
//				.forEach(i -> sb.append(i+" "));
		    
			return sb.toString();
		}

	}
	

	// ---------------------- test API ------------------------------

	public static class MyStringReader implements StringReader {
		@Override
		public String readString() {
			return "Hello Hello World World Q2";
		}
	}

	public static class MyIntArrayReader implements IntArrayReader {
		@Override
		public int[] readIntArray() {
			int[] r = { 100, 100, 50, 50, 13, 14 };
			return r;
		}
	}

	public static void testAPI() {
		StringReader reader = new MyWordFilter(new MyStringReader());
		System.out.println(reader.readString()); // Hello;World;Q2;

		reader = new MyWordFilter(new MyIntArrayToStringReader(new MyIntArrayReader()));
		System.out.println(reader.readString()); // 100;50;13;14;
	}

	public static void main(String[] args) {
		testAPI();
	}
}
