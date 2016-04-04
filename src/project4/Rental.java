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
	 * This calculates frequent points for the rental of release movie with duration of more than 2 days
	 * @return bonus points
	 */
	public int calculateRentalBonusPoints() {
		int bonus = 0;
		if(this.renting instanceof Movie) {
			if(this.renting instanceof NewReleaseMovie && rewardEligible()) {
				bonus = RENTAL_BONUS_POINT;
			}
		}
		return bonus;
	}
	
	public boolean rewardEligible() {
		return (rentalDuration >= MIN_DURANTION_FOR_BONUS);
	}

}
