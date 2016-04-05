package project4;

public class XBoxGame extends VideoGame {
	
	public XBoxGame(String title) {
		super(title);
		rentalDurationLimit = 5;
		rentalBaseCost = 1.5;
		lateFee = 2;
	}

}
