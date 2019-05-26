package Ex7;


import Ex7.Q1.Boss;
import Ex7.Q1.Mobster;



public class MainTrain {

	public static void main(String[] args) {		
		test1();
		test2();
		System.out.println("done");
	}


	private static void test1() {
		if( !Boss.class.getSuperclass().equals(Mobster.class))
			System.out.println("Boss is not a Monster (-10)");
		try {
			if(! Mobster.class.getField("name").getType().equals(String.class))
				System.out.println("name is not a String (-10)");
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.println("name or nickname do not exist (-10)");
		}
		
	}
	
	private static void test2() {
		Q2.a();		
		String s="";
		while(!A.q.isEmpty())
			s+=A.q.poll();		
		if(!A.s.equals("1234567891012345678910"))
			System.out.println("Q2a wrong logic for m1,m2 (-12)");
		
		if(!s.contains("566778899"))
			System.out.println("Q2a wrong logic for m3,m4,m5 (-12)");
		
	}
	

}
