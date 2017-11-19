

/**
 * The manager class should be extended from the Employee class
 * 
 * TODO write the syntax for the Manager class to Extend the Employee class
 * 
 */
public class Manager extends Employee{
	//maxSize is the total amount of employees that this manager can support
	int maxSize;
	
	/*
	 * This constructor will not work correctly until the Manager class has been extended from the Employee class
	 * Without extending employee, the manager class does not understand the variables name and salary
	 */
	public Manager(String name, int salary, int maxSize) {
		this.name = name;
		this.salary = salary;
		this.maxSize = maxSize;
	}
	
	/**
	 * This method will attempt to hire a new employee.
	 * However, if the total teamSize is larger then maxSize, it will throw an error
	 * 
	 * @param TeamSize
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Employee HireEmployee(int TeamSize, String name) throws Exception {
		if(TeamSize < maxSize) {
			return new Employee(name);
		}
		else {
			throw new Exception();
		}
	}
	
	
}
