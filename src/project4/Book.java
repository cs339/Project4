package project4;

public abstract class Book extends Rentable {
	
	public Book(String title) {
		super(title);
	}
	
	public abstract double calculateRentalCost(int daysRented);
	
	public abstract double calculateSaleCost();

}