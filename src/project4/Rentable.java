package project4;

public abstract class Rentable {
	
	public String title;
	
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
	
	public abstract double calculateRentalCost(int daysRented);
	
	/**
	 * Calculates cost of buying item
	 * 
	 * @return rental cost
	 */
	
	public abstract double calculateSaleCost();
	
}
