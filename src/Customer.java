package hw2_sample;

import java.util.ArrayList;

/**
 * 
 * @author thanhng
 *
 */
public class Customer {

	private String name;
	private ArrayList<Rental> rentalList;
	private int preferredRenterPoints;
	private double totalCost;
	
	public Customer(String name) {
		this.name = name;
		rentalList = new ArrayList<>();
		preferredRenterPoints = 0;
		totalCost = 0.0;
	}
	
	/**
	 * Update rental information for this customer each time s/he rents a new product
	 * @param rental
	 */
	public void addRentalUnit(Rental rental) {
		rentalList.add(rental);
		totalCost = rental.getCost();
		addPreferredRenterPoints(rental);
	}
	
	/**
	 * Prepare for the rental statement
	 * @return
	 */
	public String getRentalStatement() {
		StringBuilder statement = new StringBuilder();
		
		/* Get the summary for rental units of this customer */
		for(Rental rental : rentalList) {
			// calculate cost for each rental
			
			// append summary to statement
		}
		
		return statement.toString();
	}
	
	private void addPreferredRenterPoints(Rental rental) {
		//
		preferredRenterPoints ++;
		
		// Any bonus is also included
		preferredRenterPoints += rental.calculateRentalBonusPoints();
	}
}
