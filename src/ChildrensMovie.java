public class ChildrensMovie extends Movie {
	
	public ChildrensMovie(String title){
		super(title);
	}
	
	public double getPrice(int daysRented){
		double price = 1.5;
        if (daysRented > 3) {
            price += (daysRented - 3) * 1.5;
        }
        return price;
	}
}
