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
	private ArrayList<Rental> saleList;
	private int preferredRenterPoints;
	private double totalCost;
	
	public Customer(String name) {
		this.name = name;
		rentalList = new ArrayList<>();
		saleList = new ArrayList<>();
		preferredRenterPoints = 0;
		totalCost = 0.0;
	}
	
	/**
	 * Update rental information for this customer each time s/he rents a new product
	 * @param rental
	 */
	public void addRentalUnit(Rental rental) {
		rentalList.add(rental);
		totalCost += rental.getCost();
		addPreferredRenterPoints(rental);
	}
	
	/**
	 * Update sale information for this customer each time s/he buys a new product
	 */
	public void addSaleUnit(Rental rental) {
		saleList.add(rental);
		totalCost += rental.getSaleCost();
	}
	
	private Statement generateStatement() {
		Statement statement = new Statement();
        statement.addLine("Record for " + name);
        for (Rental rental : rentalList) {
            double currentRentalAmount = 0;
            currentRentalAmount += rental.getCost();
            statement.addLine(rental.getRenting().getTitle() + "\t" + String.valueOf(currentRentalAmount));
        }

        for (Rental rental : saleList) {
            double currentSaleAmount = 0;
            currentSaleAmount += rental.getSaleCost();
            statement.addLine(rental.getRenting().getTitle() + "\t" + String.valueOf(currentSaleAmount));
        }
          
        statement.addLine("Amount owed is " + String.valueOf(totalCost));
        statement.addLine("You earned " + String.valueOf(preferredRenterPoints) + " frequent renter points");
        return statement;
	}
	
	/**
	 * Prepare for the rental statement
	 * @return
	 */
	public String getRentalStatement() {
		return generateStatement().toString();
	}
	
	private void addPreferredRenterPoints(Rental rental) {
		//
		preferredRenterPoints += totalCost / 5;
		
		// Any bonus is also included
		preferredRenterPoints += rental.calculateRentalBonusPoints();
	}

	public void checkout() {
		Statement statement = generateStatement();
        statement.printStatement();
        statement.printHTMLStatement();
    }
}
