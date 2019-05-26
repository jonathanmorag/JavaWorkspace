
public class Pizza implements Food {

	@Override
	public int getPrice() {
		return 50;
	}

	@Override
	public String toString() {
		return this.getPrice()+"";
	}

	public static void main(String[] args) {
		Food pizza = new Olives(new Pizza());
		System.out.println(pizza);
	}


}
