import java.util.Random;

/**
 * TODO: nothing, this should be okay
 */
public class Stocker extends Employee {
	
	int selves = 0;
	
	public Stocker () {
		
	}
	//Solution to stockshelf in Store Class, but could that method be called without a constructor.
	public Stocker (String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * a method which randomly determines if the Stocker has finished stocking the selves
	 * @return 
	 */
	public Boolean StockShelf() {
		Random rand = new Random();
		Boolean Finished = rand.nextBoolean();
		if(Finished == true) {
			selves++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int StockShift() {
		Stocker stocker = new Stocker();
		while(stocker.StockShelf()) {
			stocker.StockShelf();
		}
		int sum = stocker.selves;
		return sum;
	}

}
