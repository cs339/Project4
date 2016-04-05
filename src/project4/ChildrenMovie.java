package project4;

public class ChildrenMovie extends Movie {
		
	public ChildrenMovie(String title) {
		super(title);
		rentalDurationLimit = 2;
		rentalBaseCost = 2;
		lateFee = 1.5;
	}
	
}
