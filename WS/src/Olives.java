
public class Olives implements Food {

	Food f;

	public Olives(Food f) {
		this.f = f;
	}

	@Override
	public int getPrice() {
		return f.getPrice() + 7;
	}
	
	@Override
	public String toString() {
		return "Total price is: "+getPrice();
	}

}