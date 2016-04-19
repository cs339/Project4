package project4;

import java.util.ArrayList;

public interface RenterPoints {
	
	public int calculatePoints(ArrayList<Rental> movieList, int points);
	
	public boolean rewardEligible(ArrayList<Rental> movieList, int age);
	
}
