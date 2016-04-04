package project4;

public abstract class VideoGame extends Rentable {
	
	public VideoGame(String title) {
		super(title);
	}
	
	public abstract double calculateRentalCost(int daysRented);
	
	public abstract double calculateSaleCost();

}