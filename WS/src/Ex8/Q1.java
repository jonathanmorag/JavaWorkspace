package Ex8;

import java.util.Iterator;
import java.util.LinkedList;

public class Q1 {

	@SuppressWarnings("serial")
	public class Ring<E> extends LinkedList<E>{
		
		public class RingIterator implements Iterator<E> {

			Iterator<E> it; 
			
			public RingIterator() {
				it = Ring.super.iterator();
			}
			
			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public E next() {
				if(!it.hasNext())
					it = listIterator();
				return it.next();
			}
			
		} // end of inner RingIterator class
		
		@Override
		public Iterator<E> iterator(){
			return new RingIterator();
		}
	}
	
	public void APItest(){
		
		Ring<String> r=new Ring<>();
		r.add("a");
		r.add("b");
		r.add("c");
		r.add("d");
		Iterator<String> it=r.iterator();
		for(int i=0;i<r.size()+2;i++)
			System.out.print(it.next()+",");
		System.out.println(); // a,b,c,d,a,b,
	}
	
	public static void main(String[] args) {
		new Q1().APItest();
	}
	
}
