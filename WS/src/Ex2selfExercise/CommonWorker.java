package Ex2selfExercise;

public abstract class CommonWorker implements Worker {
	
    String name;
    int age;
    double salary;

    public CommonWorker() {}
    
    /* public CommonWorker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    } */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
