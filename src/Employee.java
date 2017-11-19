/*
 * Employee has multiple different constructors
 */
public class Employee {

	String name;
	int salary;
	public Employee() {
		
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * TODO Override the toString method to return the name and salary of the employee
	 */
	public String toString() {
		return "Name: " + name + ", Salary: " + salary;
	}

}
