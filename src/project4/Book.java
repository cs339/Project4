package project4;

public abstract class Book {

	private String title;
	private String category;
	
	public Book(String title, String category) {
		this.title = title;
		this.category = category;
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