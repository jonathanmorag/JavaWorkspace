
// import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTest2 {

	static String root = "./cache";
	
	static {
		new File(root).mkdirs();
	}
	
	public static void main(String[] args) throws IOException {
		Stream<String> errors = Files.lines(Paths.get(root+"//errors.txt"))
				.filter(s -> s.startsWith("ERROR: "))
				.limit(5);
		
		List<String> list = errors.collect(Collectors.toList());
		errors.close();
		list.forEach(s -> System.out.println(s));
		
//		List<String> errors = new ArrayList<>();
//		BufferedReader in = new BufferedReader(new FileReader("errors.txt"));
//		String line;
//		while(errors.size() < 5 && (line = in.readLine()) != null) {
//			if(line.startsWith("ERROR: "))
//				errors.add(line);
//		}
//		in.close();
//		errors.forEach(s -> System.out.println(s));
	}  

}
