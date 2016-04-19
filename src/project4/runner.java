package project4;

public class runner {

	public static void main(String[] args) {
		NewReleaseMovie firstMovie = new NewReleaseMovie("Movie 1");
		ChildrenMovie secondMovie = new ChildrenMovie("Movie 2");
		RegularMovie thirdMovie = new RegularMovie("Movie 3");
		Book b1 = new ChildrenBook("To Kill A Mockingbird");
		
		Rental firstRental = new Rental(firstMovie, 2);
		Rental secondRental = new Rental(secondMovie, 2);
		Rental thirdRental = new Rental(thirdMovie, 2);
		Rental fourthRental = new Rental(b1, 5);
		
		Customer customer = new Customer("Joe", 21);
		
		customer.addRentalUnit(firstRental);
		customer.addRentalUnit(secondRental);
		customer.addRentalUnit(thirdRental);
		customer.addRentalUnit(fourthRental);
		
		customer.addSaleUnit(firstRental);
		customer.addSaleUnit(secondRental);
		customer.addSaleUnit(thirdRental);
		customer.addSaleUnit(fourthRental);
		
		customer.checkout();
	}

}