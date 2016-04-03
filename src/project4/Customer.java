package project4;

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
	 * Update sale information for this customer each time s/he buys a new product
	 */
	public void addSaleUnit() {
		//TODO
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

	public void checkout() {
    	Statement statement = new Statement();
    	double totalAmount = 0;
        int frequentRenterPoints = 0;
        statement.addLine("Rental Record for " + name);
        for (Rental rental : rentalList) {
            double currentRentalAmount = 0;
            currentRentalAmount += rental.getCost();
            frequentRenterPoints+=rental.calculateRentalBonusPoints();
            statement.addLine(rental.getMovie().getTitle() + "\t" + String.valueOf(currentRentalAmount));
            totalAmount += currentRentalAmount;
        }
        statement.addLine("Amount owed is " + String.valueOf(totalAmount));
        statement.addLine("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        statement.printStatement();
        statement.printHTMLStatement();
    }
}