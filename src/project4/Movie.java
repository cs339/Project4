package project4;

public abstract class Movie extends Rentable {
	
	public Movie(String title) {
		super(title);
	}
	
	public abstract double calculateRentalCost(int daysRented);
	
	public abstract double calculateSaleCost();
	
}
