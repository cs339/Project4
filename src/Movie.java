public abstract class Movie {
    
    private String _title;
    
    public Movie(String title) {
        _title = title;
    }
    
    public String getTitle() {
        return _title;
    }
    
	public abstract double getPrice(int daysRented);

}