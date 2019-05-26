import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest3 {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream out = new FileOutputStream("f1.dat");
		out.write("this\nis\na\nbinary\nfile!".getBytes());
		out.close();
		
		// FileInputStream in = new FileInputStream("f1.dat");
		/* PrintWriter pw = new PrintWriter(new FileWriter("f2.txt"));
		int c;
		while((c = in.read()) != -1) {
			if(c == '\n')
				pw.println();
			else
				pw.print((char)c);
		} */
		
		//in.close();
		
		Files.lines(Paths.get("f1.dat")).forEach(System.out::println);
		System.out.println("done");
	}  
	
}
