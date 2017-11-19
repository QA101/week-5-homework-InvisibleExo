import java.util.ArrayList;

public class Store {

	ArrayList<Employee> employees = new ArrayList<Employee>();
	Manager manager;
	Stocker stocker;
	
	
	public static void main(String[] args) {
		Store s = new Store();
		System.out.println("Employees are: ");
		s.PrintEmployees();
		System.out.println();
		System.out.println("Manager of Store s is: " );
		s.PrintManager();
		
		//TODO: The manager doesn't know how to StockShelfs.
		//Manager can have stockers perform this role.
		//How can we have an Employee object(non-manager) call the StockShelf method from the Stocker class?
		
		//Alternate solution is create a constructor in Stocker Class. Can it be simpler for this type of code?
		System.out.println("How many shelves have been stocked during your shift " + s.stocker.name + " ?");
		//StockShift contains StockSelf method in the Stocker Class.
		System.out.println(s.stocker.StockShift());
		
		/**
		 * Challenge Concept: try/catch and throwing an exception
		 * 
		 * Here I am attempting to hire more employees than my manager can handle.
		 * If the manager can not support the number of employees being hired, it will throw an exception
		 */
		s.HireEmployee();
		s.PrintEmployees();
	}
	
	public Store() {
		//Notice I am using different constructors for Employees
		employees.add(new Employee("Tom"));
		employees.add(new Employee("Jane", 40000));
		
		//Assigning employees as stockers 
		this.stocker = new Stocker("Peter", 35000);
		employees.add(stocker);
		
		/*
		 * This add statement will not work until the Manager class has been extended
		 * However, I never set the manager correctly
		 * 
		 * TODO: assign the manager for the store class and add the manager to the employee list
		 * Solution: assign the mangager(this.manager) in the global field as a new manager object, then add manager to the employees ArrayList.
		 */
		this.manager = new Manager("Tim", 50000, 5);
		employees.add(manager);
		
		
		//Notice that I can put a manager inside a list of employees because Manager is a subclass of Employee.
	}
	
	public void PrintEmployees() {
		System.out.println("Employees");
		for(Employee e : employees) {
			System.out.println(e);
		}
	}
	
	public void PrintManager() {
		System.out.println(manager);
	}
	
	
	
	//Notice this is a private method
	//....James, Kenny and Sasha aren't going to make the team.....aren't they....(I know the answer. This is for more dramatic effect.)
	private void HireEmployee() {
		try {
			employees.add(manager.HireEmployee(employees.size(), "Wanda"));
			employees.add(manager.HireEmployee(employees.size(), "James"));
			employees.add(manager.HireEmployee(employees.size(), "Kenny"));
			employees.add(manager.HireEmployee(employees.size(), "Sasha"));
		}
		catch(Exception e) {
			System.out.println("Number of employees has hit max size. We will keep your application and recommendations archived for possible future hiring.");
		}
	}

}
