package project4;

public abstract class CD extends Rentable {
	
	public CD(String title) {
		super(title);
	}
	
	public abstract double calculateRentalCost(int daysRented);
	
	public abstract double calculateSaleCost();

}