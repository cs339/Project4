package project4;

import java.util.ArrayList;
import java.util.HashSet;

public class RenterPointsByCategory implements RenterPoints {

	@Override
	public int calculatePoints(ArrayList<Rental> movieList, int points) {
		return points *= 2;
	}

	@Override
	public boolean rewardEligible(ArrayList<Rental> movieList, int age) {
		HashSet<String> categories = new HashSet<String>();
		for(Rental rental : movieList) {
        	categories.add(rental.getRenting().getClass().toString());
        }
		if(categories.size() > 2) return true;
		return false;
	}

}
