package Ex5;

import Ex5.Moveable.Direction;

public class PushableAdapter implements Pushable {
	
	Moveable m;
	
	public PushableAdapter(Moveable m) {
		this.m = m;
	}
	
	@Override
	public void push(int heading) {
		if (heading >= 45 && heading <= 134)
			m.moveMe(Direction.right);
		if (heading >= 135 && heading <= 224)
			m.moveMe(Direction.down);
		if (heading >= 225 && heading <= 314)
			m.moveMe(Direction.left);
		if ((heading >= 315 && heading <= 359) || (heading >= 0 && heading <= 44))
			m.moveMe(Direction.up);
	}

}
