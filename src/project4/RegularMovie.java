package project4;

public class RegularMovie extends Movie {
	
	/* Custom Pricing For RegularMovie */

	private final int RENTAL_DURATION_LIMIT = 2;
	private final double RENTAL_BASE_COST = 2;
	private final double LATE_FEE = 1.5;
	
	public RegularMovie(String title) {
		super(title);
	}
	
	@Override
	public double calculateRentalCost(int daysRented) {
		double rentalCost = RENTAL_BASE_COST * daysRented;
		if(daysRented > RENTAL_DURATION_LIMIT) {
			rentalCost += LATE_FEE * (daysRented - RENTAL_DURATION_LIMIT);
		}
		return rentalCost;
	}
	
	@Override
	public double calculateSaleCost(){
		return LATE_FEE * 5;
	}
}
