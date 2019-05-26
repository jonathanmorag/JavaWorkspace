package Ex7;

import java.util.concurrent.ArrayBlockingQueue;

public class A {

	public static int r,v;
	public static String s="";
	
	public static ArrayBlockingQueue<Integer> q=new ArrayBlockingQueue<>(30);
	
	public int m1(){
		r++;
		s+=r;
		return r;
	}
	public int m2(){
		v++;
		s+=v;
		return v;
	}
	public void m3(){
		try {q.put(v);} catch (InterruptedException e) {}
	}
	public void m4(){
		try {q.put(v);} catch (InterruptedException e) {}
	}
	public void m5(){
		q.poll();
	}
}
