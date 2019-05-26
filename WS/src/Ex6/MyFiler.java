package Ex6;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyFiler {
	
	static String type = ".xml";
	
	public static void writeLevel(String fileName, Level level) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(level);
		out.close();
	}
	
	/*********************************************************************************************/
	
	public static void writeLevelToXML(String fileName, Level level) {
		try {
			XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName + type));
			encoder.writeObject(level);
			encoder.close();
		} catch (FileNotFoundException e) { e.printStackTrace(); }
	}

	public static Level readLevelFromXML(String fileName) {
		try {
			XMLDecoder dec = new XMLDecoder(new FileInputStream(fileName + type));
			Level l = (Level) dec.readObject();
			dec.close();
			return l;
		} catch (FileNotFoundException e) { e.printStackTrace(); return null; }
	}

	public static void main(String[] args) throws InterruptedException {
		char[][] data = { { 1, 3, 1 }, { 0, 11, 0 }, { 14, 20, 1 } };
		Level level = new Level(data, 300, 40);
		System.out.println("Writing to file...");
		writeLevelToXML("someFile", level);
		Thread.sleep(2000);
		System.out.println("done");
		Thread.sleep(2000);
		System.out.println(readLevelFromXML("someFile"));
		System.out.println("YES! we read Level object Successfully!");
	}
  
}
