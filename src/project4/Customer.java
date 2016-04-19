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
	private int frequentRenterPoints;
	private double totalCost;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.rentalList = new ArrayList<>();
		this.saleList = new ArrayList<>();
		this.frequentRenterPoints = 0;
		this.totalCost = 0.0;
	}
	
	/**
	 * Update rental information for this customer each time s/he rents a new product
	 * @param rental
	 */
	public void addRentalUnit(Rental rental) {
		rentalList.add(rental);
		totalCost += rental.getCost();
		addFrequentRenterPoints(rental);
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
        for(Rental rental : rentalList) {
            double currentRentalAmount = rental.getCost();
            statement.addLine(rental.getRenting().getTitle() + "\t" + String.valueOf(currentRentalAmount));
        }
        ArrayList<Rental> movieList = new ArrayList<Rental>();
        for(Rental rental : rentalList) {
        	if(rental.getRenting() instanceof Movie) movieList.add(rental);
        }
        addBonusFrequentRenterPoints(movieList);
        for(Rental rental : saleList) {
            double currentSaleAmount = 0;
            currentSaleAmount += rental.getSaleCost();
            statement.addLine(rental.getRenting().getTitle() + "\t" + String.valueOf(currentSaleAmount));
        }
        statement.addLine("Amount owed is " + String.valueOf(totalCost));
        statement.addLine("You earned " + String.valueOf(this.frequentRenterPoints) + " frequent renter points");
        return statement;
	}
	
	/**
	 * Prepare for the rental statement
	 * @return
	 */
	public String getRentalStatement() {
		return generateStatement().toString();
	}
	
	private void addFrequentRenterPoints(Rental rental) {
		this.frequentRenterPoints += Math.round(rental.getCost() / 5);
	}
	
	private void addBonusFrequentRenterPoints(ArrayList<Rental> movieList) {
		RenterPoints pointsAge = new RenterPointsByAge();
		RenterPoints pointsCategory = new RenterPointsByCategory();
		RenterPoints pointsDuration = new RenterPointsByDuration();
		if(pointsAge.rewardEligible(movieList, this.age)) {
			this.frequentRenterPoints = pointsAge.calculatePoints(movieList, this.frequentRenterPoints);
		}
		if(pointsCategory.rewardEligible(movieList, this.age)) {
			this.frequentRenterPoints = pointsCategory.calculatePoints(movieList, this.frequentRenterPoints);
		}
		if(pointsDuration.rewardEligible(movieList, this.age)) {
			this.frequentRenterPoints += pointsDuration.calculatePoints(movieList, this.frequentRenterPoints);
		}
	}

	public void checkout() {
		Statement statement = generateStatement();
        statement.printStatement();
        statement.printHTMLStatement();
    }
}
