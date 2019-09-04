package javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class TestSorting {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "aTestName", "dLastName", 34);
        Employee e2 = new Employee(2, "nTestName", "pLastName", 30);
        Employee e3 = new Employee(3, "kTestName", "sLastName", 31);
        Employee e4 = new Employee(4, "dTestName", "zLastName", 25);
 
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);
        employees.add(e4);
 
        // UnSorted List
        System.out.println(employees);
 
        Collections.sort(employees);
 
        // Default Sorting by employee id
        System.out.println(employees);
    }
}
