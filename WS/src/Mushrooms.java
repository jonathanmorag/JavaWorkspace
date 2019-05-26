
public class Mushrooms implements Food {

	Food f;

	public Mushrooms(Food f) {
		this.f = f;
	}

	@Override
	public int getPrice() {
		return f.getPrice() + 10;
	}
	
	@Override
	public String toString() {
		return "Total price is: "+getPrice();
	}

}