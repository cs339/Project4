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
	private double discount;
	private int age;
	private RentalObserver rentalObserver;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.rentalList = new ArrayList<>();
		this.saleList = new ArrayList<>();
		this.frequentRenterPoints = 0;
		this.totalCost = 0.0;
		this.discount = 0.0;
	}
	
	/**
	 * Update rental information for this customer each time s/he rents a new product
	 * @param rental
	 */
	public void addRentalUnit(Rental rental) {
		rentalObserver.addRental();
		rentalList.add(rental);
		totalCost += (rental.getCost() * rentalObserver.getDiscount());
		discount += (rental.getCost() *(1 - rentalObserver.getDiscount()));
		addFrequentRenterPoints(rental);
	}
	
	/**
	 * Update sale information for this customer each time s/he buys a new product
	 */
	public void addSaleUnit(Rental rental) {
		rentalObserver.addRental();
		saleList.add(rental);
		totalCost += (rental.getSaleCost() * rentalObserver.getDiscount());
		discount += (rental.getSaleCost() *(1 - rentalObserver.getDiscount()));
	}
	
	private Statement generateStatement() {
		Statement statement = new Statement();
        statement.addLine("Record for " + name);
        rentalObserver.resetRentals();
        for(Rental rental : rentalList) {
        	rentalObserver.addRental();
        	double currentRentalAmount = (rental.getSaleCost() * rentalObserver.getDiscount());
            //double currentRentalAmount = rental.getCost();
            statement.addLine(rental.getRenting().getTitle() + "\t" + String.valueOf(currentRentalAmount));
        }
        ArrayList<Rental> movieList = new ArrayList<Rental>();
        for(Rental rental : rentalList) {
        	if(rental.getRenting() instanceof Movie) movieList.add(rental);
        }
        addBonusFrequentRenterPoints(movieList);
        for(Rental rental : saleList) {
            double currentSaleAmount = 0;
            rentalObserver.addRental();
            currentSaleAmount += (rental.getSaleCost() * rentalObserver.getDiscount());
            //currentSaleAmount += rental.getSaleCost();
            statement.addLine(rental.getRenting().getTitle() + "\t" + String.valueOf(currentSaleAmount));
        }
        
        /*double purchaseDiscount = 0;
        if(rentalList.size() >= 3 && rentalList.size() <= 5) purchaseDiscount = 0.2;
        else if(rentalList.size() > 5) purchaseDiscount = 0.5;
        for(Rental sale : saleList){
        	discount += sale.getSaleCost()*purchaseDiscount;
        }*/
        
        
        statement.addLine("Subtotal is " + String.valueOf(totalCost + discount));
        statement.addLine("Discount is " + String.valueOf(discount));
        statement.addLine("Amount owed is " + String.valueOf(totalCost));// - discount));
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
		this.frequentRenterPoints += Math.round((rental.getCost() * rentalObserver.getDiscount()) / 5);
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
	
	public void attachObserver(RentalObserver observer){
		this.rentalObserver = observer;
	}
}
