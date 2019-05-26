package Ex10;

import java.util.Observable;
import java.util.Observer;

public class Property<V> extends Observable implements Observer {
	
	V v;
	
	public void bind(Property<V> p) {
		addObserver(p);
	}
	
	public void setValue(V v) {
		this.v = v;
		setChanged();
		notifyObservers(v);
	}
	
	public V getValue() {
		return v;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		V val = (V)arg;
		if (this.getValue() != val)
			this.setValue(val);
	}
	
	
}



/* import java.util.ArrayList;

public class Property<V> {
	
	V v;
	ArrayList<Property<V>> bounds;
	
	public Property() {
		bounds = new ArrayList<>();
	}
	
	public void bind(Property<V> p) {
		bounds.add(p);
	}
	
	public void setValue(V v) {
		this.v = v;
		for(Property<V> p : bounds)
			p.setValue(v);
	}
	
	public V getValue() {
		return v;
	}
	
	
} */
