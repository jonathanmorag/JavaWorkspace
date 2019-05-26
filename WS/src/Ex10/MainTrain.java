package Ex10;

import Ex10.Controller.Command;

public class MainTrain {

	
	public static void q1(){
		Property<Integer> i=new Property<Integer>();
		Property<Integer> j=new Property<Integer>();
		Property<Integer> k=new Property<Integer>();
		Property<Integer> l=new Property<Integer>();
		Property<Integer> m=new Property<Integer>();
		Property<Integer> n=new Property<Integer>();
		Property<Integer> o=new Property<Integer>();
		i.setValue(0);
		j.setValue(0);
		k.setValue(0);
		l.setValue(0);
		m.setValue(0);
		n.setValue(0);
		o.setValue(0);
		
		i.bind(j);
		i.bind(k);
		i.bind(l);
		j.bind(m);
		m.bind(n);
		
		i.setValue(5);
		if(j.getValue()!=5)
			System.out.println("single bind does not work (-10)");
		if(k.getValue()!=5)
			System.out.println("double bind does not work (-10)");
		if(l.getValue()!=5)
			System.out.println("multiple bind does not work (-5)");
		if(m.getValue()!=5)
			System.out.println("single transitive bind does not work (-5)");
		if(n.getValue()!=5)
			System.out.println("double transitive bind does not work (-10)");
		
		// test mistakes of static implementations 
		if(o.getValue()==5)
			System.out.println("properties which are not bound are changed (-10)");
		
		
	}
	
	
	static String res="";
	
	static class MyCommandT implements Command{
		private int id;
		private long time;

		public MyCommandT(int id,long time) {
			this.id=id;
			this.time=time;
		}
		@Override
		public int getID() {
			return id;
		}

		@Override
		public void execute() {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {}
			res+=id+"";
		}		
	}
	
	public static void q2(){
		
		Controller controller=new Controller();
		controller.insertCommand(new MyCommandT(1, 30));
		controller.executeOne();
		if(!res.equals("1"))
			System.out.println("failed to insert and execute command for question 2 (-15)"); 
		controller.insertCommand(new MyCommandT(2, 20));
		controller.insertCommand(new MyCommandT(3, 10));
		controller.executeAll();
		if(res.length()!=3)
			System.out.println("failed to insert and execute several commands for question 2 (-15)"); 
		res="";
		controller.insertCommand(new MyCommandT(1, 30));
		controller.insertCommand(new MyCommandT(2, 20));
		controller.insertCommand(new MyCommandT(3, 10));
		controller.executeAll(); // 3,2,1
		if(!res.equals("321"))
			System.out.println("failed logic for question 2 (-20)");
	}

	public static void main(String[] args) {
		// 1
		q1();
		q2();
		System.out.println("done");
		
	}

}
