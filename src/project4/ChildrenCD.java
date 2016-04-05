package project4;

public class ChildrenCD extends CD {

	
	public ChildrenCD(String title) {
		super(title);
		rentalDurationLimit = 3;
		rentalBaseCost = 1;
		lateFee = 1.5;
	}
}
