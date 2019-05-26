import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileTest {
	
	static String root = "./cache/";
	
	static {
		new File(root).mkdirs();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/* PrintWriter pw = new PrintWriter(new FileWriter(root+"out.dat"));
		pw.println("It was a long day today...");
		pw.flush();
		pw.close();
		
		Scanner myScanner = new Scanner(new BufferedReader(new FileReader(root+"out.dat")));
		while (myScanner.hasNext())
			System.out.print(myScanner.next()+" ");
		myScanner.close(); */
		
		Student s1 = new Student("Jonathan", 25);
		s1.addCourse(1, "Algorithms 1");
		s1.addCourse(31, "PTM 1");
		s1.addCourse(222, "Calculus 3");
		s1.addCourse(76, "Statistics");
		// System.out.println(s1);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(root+"s1.dat"));
		out.writeObject(s1);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(root+"s1.dat"));
		Student s = (Student)in.readObject();
		out.close();
		in.close();
		
		System.out.println(s);
		System.out.println("done");
	}
}
