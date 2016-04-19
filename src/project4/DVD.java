package project4;

public abstract class DVD extends Rentable {
	
	public DVD(String title) {
		super(title);
	}
	
	public abstract double calculateRentalCost(int daysRented);
	
	public abstract double calculateSaleCost();
	
}