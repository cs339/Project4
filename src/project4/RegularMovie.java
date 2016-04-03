package project4;

/**
 * 
 * @author thanhng
 *
 */
public class RegularMovie extends Movie {

	/* */
	private final int RENTAL_DURATION_LIMIT = 2;
	private final double RENTAL_BASE_COST = 2;
	private final double LATE_FEE = 1.5;
	
	public RegularMovie(String title, String category) {
		super(title, category);
	}
	
	@Override
	public double calculateRentalCost(int daysRented) {
		double rentalCost = RENTAL_BASE_COST;
		
		// Additional fee calculation in case rental is expired
		if(daysRented > RENTAL_DURATION_LIMIT) {
			// do calculation here
		}
		return rentalCost;
	}
	
	@Override
	public double calculateSaleCost(){
		return LATE_FEE * 5;
	}
}
