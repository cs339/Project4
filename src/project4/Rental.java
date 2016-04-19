package project4;

public class Rental {
	
	private final int RENTAL_BONUS_POINT = 1;
	
	private final int MIN_DURANTION_FOR_BONUS = 2;
	
	private Rentable renting;

	private int rentalDuration;
	
	/**
	 * @param movie
	 * @param duration
	 */
	public Rental(Rentable renting, int duration) {
		this.renting = renting;
		this.rentalDuration = duration;
	}
	
	public Rentable getRenting() {
		return this.renting;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	
	/**
	 * This calculates cost for this rental unit
	 * @return
	 */
	public double getCost() {
		return this.renting.calculateRentalCost(rentalDuration);
	}
	
	
	/**
	 * This calculates the sale cost for this rental unit
	 * @return
	 */
	public double getSaleCost() {
		return this.renting.calculateSaleCost();
	}
	
	/**
	 * This returns the bonus point
	 * @return
	 */
	public int getBonusRental() {
		return this.RENTAL_BONUS_POINT;
	}
	
	/**
	 * This is the minimum duration for bonus
	 * @return
	 */
	public int getMinDuration() {
		return this.MIN_DURANTION_FOR_BONUS;
	}

}
