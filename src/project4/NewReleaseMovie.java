package project4;

/**
 * Although New Release is not really a category of movie (like Regular and Children,
 * but this creation facilitates calculations that are done for its own sake
 * @author thanhng
 *
 */
public class NewReleaseMovie extends Movie {

	private final double RENTAL_COST_MUL = 3;
	
	public NewReleaseMovie(String title) {
		super(title);
	}
	
	@Override
	public double calculateRentalCost(int daysRented) {
		return daysRented * RENTAL_COST_MUL;
	}
	
	@Override
	public double calculateSaleCost(){
		return 20; //TODO
	}

}
