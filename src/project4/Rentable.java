package project4;

public abstract class Rentable {
	
	public String title;
	protected int rentalDurationLimit;
	protected double rentalBaseCost;
	protected double lateFee;
	
	public Rentable(String title) {
		this.title = title;
	}
	
	/**
	 * Returns title of item
	 */
	
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @param daysRented
	 * Duration of a movie rental unit
	 * 
	 * Calculates cost of renting item
	 * 
	 * @return rental cost
	 */
	
	public double calculateRentalCost(int daysRented) {
		double rentalCost = rentalBaseCost * daysRented;
		if(daysRented > rentalDurationLimit) {
			rentalCost += lateFee * (daysRented - rentalDurationLimit);
		}
		return rentalCost;
	}
	
	/**
	 * Calculates cost of buying item
	 * 
	 * @return rental cost
	 */
	
	public double calculateSaleCost() {
		return rentalBaseCost * 5;
	}

}
