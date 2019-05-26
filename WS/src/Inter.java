
public interface Inter {
	void func();
	
	public class A implements Inter {
		
		@Override
		public void func() {
			System.out.println("This is class A");	
		}
		
		public void a() {
			System.out.println("Function that belongs only to A");
		}
	}
	
	public class Proxy implements Inter {
		
		A a;

		public Proxy(A a) {
			this.a = a;
		}
		
		@Override
		public void func() {
			System.out.println("My Proxy, running my A functions...");
			a.func();
			a.a();
		}
	}
	
	public static void main(String[] args) {
		Proxy proxy = new Proxy(new A());
		proxy.func();
	}
}
