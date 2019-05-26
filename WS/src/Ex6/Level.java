package Ex6;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Level implements Serializable {

	private char[][] data;
	private int cx, cy;

	
	public Level(char[][] data, int cx, int cy) {
		this.data = data;
		this.cx = cx;
		this.cy = cy;
	}

	public Level() {
		data = null;
		cx = cy = 0;
	}

	public char[][] getData() {
		return data;
	}

	public void setData(char[][] data) {
		this.data = data;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}
	
	public String MatToString() {
		StringBuilder sb = new StringBuilder();
		for(char[] rows : data) {
			for (char cols : rows)
				sb.append(Integer.valueOf(cols)+" ");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Level contains -\n\nMat:\n"+MatToString()+ "\nCX: "+ cx + "\nCY: " +cy;
	}
	
	public static void main(String[] args) {
		char[][] data = { { 1, 1, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		Level level = new Level(data, 300, 40);
		System.out.println(level);
	}

}
