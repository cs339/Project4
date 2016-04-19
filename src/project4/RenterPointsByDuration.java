package project4;

import java.util.ArrayList;

public class RenterPointsByDuration implements RenterPoints {

	@Override
	public int calculatePoints(ArrayList<Rental> movieList, int points) {
		points = 0;
		for(Rental rental : movieList) {
			if(rental.getRenting() instanceof NewReleaseMovie) {
				points += rental.getBonusRental();
			}
        }
		return points;
	}

	@Override
	public boolean rewardEligible(ArrayList<Rental> movieList, int age) {
		for(Rental rental : movieList) {
			if(rental.getRenting() instanceof NewReleaseMovie && rental.getRentalDuration() >= rental.getMinDuration()) {
				return true;
			}
        }
		return false;
	}

}
