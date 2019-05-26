import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Student extends Observable implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	String name;
	int age;
	Map<Integer, String> courses = new HashMap<>();
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers("Name has changed!");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		setChanged();
		notifyObservers("Age has changed!");
	}

	public Map<Integer, String> getCourses() {
		return courses;
	}

	public void setCourses(Map<Integer, String> courses) {
		this.courses = courses;
	}
	
	public void addCourse(int id, String courseName) {
		courses.put(id, courseName);
		setChanged();
		notifyObservers("Course added!");  
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + "\nAge: " + age + "\nCourses: ");
		if (courses.size() > 0)
			courses.values().forEach(v -> sb.append(v + ", "));
		else {
			sb.append("Not registered to courses yet");  
			return sb.substring(0, sb.length());
		}
		return sb.substring(0, sb.length() - 2);
	}
	
	
	public static void main(String[] args) {
		Student s = new Student("Jonathan", 25);
		System.out.println(s);
		System.out.println("**************************************************");
		s.addObserver((o, arg)-> {
			System.out.println(arg);
		});

		s.setName("Royi");
		s.setAge(26);
		s.addCourse(1212, "Algorithms 2");
		System.out.println(s);
		System.out.println("**************************************************");
		System.out.println("done");
	}
	
}
