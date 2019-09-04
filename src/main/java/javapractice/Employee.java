package javapractice;

public class Employee implements Comparable<Employee> {
 
    private int id = -1;
    private String firstName = null;
    private String lastName = null;
    private int age = -1;
 
    public Employee(int id, String fName, String lName, int age) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }
 
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
 
    // Setters and Getters
 
    @Override
    public String toString() {
        return "Employee : " + id + " - " + firstName + " - " + lastName + " - " + age + "\n";
    }
}