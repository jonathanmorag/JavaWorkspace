package Ex4;

import java.util.HashMap;
import java.util.Map;

public class GenericFactory<Product> {

	private interface Creator<Product> {
		public Product create(); // no unhandled exceptions
	}

	Map<String, Creator<Product>> map;

	public GenericFactory() {
		map = new HashMap<>();
	}

	public void insertProduct(String key, Class<? extends Product> c) {
		map.put(key, ()-> {
			try {
				return c.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return null;
		});

	}

	public Product getNewProduct(String key) {
		Creator<Product> c = map.get(key);
		if (c != null)
			return c.create();
		return null;
	}
}
