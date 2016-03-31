package hw2_sample;

/** 
 * 
 * @author thanhng
 *
 */
public abstract class Movie {

	private String title;
	
	public Movie(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * 
	 * @param daysRented
	 * 	Duration of a movie rental unit
	 * @return rental cost
	 */
	public abstract double calculateRentalCost(int daysRented);
}
