package project4;

/**
 * 
 * @author thanhng
 *
 */
public class Rental {
	
	private final int RENTAL_BONUS_POINT = 1;
	private final int MIN_DURANTION_FOR_BONUS = 2;
	
	private Movie movie;
	// number of days the movie has been rented
	private int rentalDuration;
	
	/**
	 * 
	 * @param movie
	 * @param duration
	 */
	public Rental(Movie movie, int duration) {
		this.movie = movie;
		this.rentalDuration = duration;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	
	/**
	 * This calculates cost for this rental unit
	 * @return
	 */
	public double getCost() {
		return movie.calculateRentalCost(rentalDuration);
	}
	
	/**
	 * This calculates frequent points for the rental of release movie with duration of more than 2 days
	 * @return bonus points
	 */
	public int calculateRentalBonusPoints() {
		int bonus = 0;
		if(movie instanceof NewReleaseMovie && rewardEgligble())
			bonus = RENTAL_BONUS_POINT;
		
		return bonus;
	}
	
	public boolean rewardEgligble() {
		return (rentalDuration >= MIN_DURANTION_FOR_BONUS);
	}

}
