package project4;

/** 
 * 
 * @author thanhng
 *
 */
public abstract class Movie {

	private String title;
	private String category;
	
	public Movie(String title, String category) {
		this.title = title;
		this.category = category; //TODO: Should this be an object?
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	/**
	 * 
	 * @param daysRented
	 * 	Duration of a movie rental unit
	 * @return rental cost
	 */
	public abstract double calculateRentalCost(int daysRented);
	
	public abstract double calculateSaleCost();
}
