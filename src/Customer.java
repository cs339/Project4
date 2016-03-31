import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();
    
    public Customer (String name) {
        this.name = name;
    }
    
    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    
    public String getName() {
        return name;
    }
    
    public void checkout() {
    	Statement statement = new Statement();
    	double totalAmount = 0;
        int frequentRenterPoints = 0;
        statement.addLine("Rental Record for " + getName());
        for (Rental rental : rentals) {
            double currentRentalAmount = 0;
            currentRentalAmount += rental.getMovie().getPrice(rental.getDaysRented());
            frequentRenterPoints+=rental.calcFrequentRenterPoints();
            statement.addLine(rental.getMovie().getTitle() + "\t" + String.valueOf(currentRentalAmount));
            totalAmount += currentRentalAmount;
        }
        statement.addLine("Amount owed is " + String.valueOf(totalAmount));
        statement.addLine("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        statement.printStatement();
        statement.printHTMLStatement();
    }
    
}