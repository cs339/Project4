package project4;

public class RegularMovie extends Movie {
		
	public RegularMovie(String title) {
		super(title);
		rentalDurationLimit = 2;
		rentalBaseCost = 2;
		lateFee = 2.5;
	}
	
}
