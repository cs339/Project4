package project4;

public class ChildrenBook extends Book {
		
	public ChildrenBook(String title) {
		super(title);
		rentalDurationLimit = 2;
		rentalBaseCost = .5;
		lateFee = 1;
	}
	
}
