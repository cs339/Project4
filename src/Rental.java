public class Rental {
    private Movie _movie;
    private int   _daysRented;
    
    public Rental(Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }
    
    public int calcFrequentRenterPoints(){
    	int frequentRenterPoints = 1;
    	if ((getMovie().getClass() == NewReleaseMovie.class) && (getDaysRented() > 1)) {
            frequentRenterPoints++;
    	}
    	return frequentRenterPoints;
    }
    
}