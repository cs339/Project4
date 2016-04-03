package project4;

public class runner {

	public static void main(String[] args) {
		NewReleaseMovie firstMovie = new NewReleaseMovie("Movie 1", "Category 1");
		ChildrenMovie secondMovie = new ChildrenMovie("Movie 2", "Category 1");
		RegularMovie thirdMovie = new RegularMovie("Movie 3", "Category 1");
		Rental firstRental = new Rental(firstMovie, 2);
		Rental secondRental = new Rental(secondMovie, 2);
		Rental thirdRental = new Rental(thirdMovie, 2);
		Customer customer = new Customer("Joe");
		customer.addRentalUnit(firstRental);
		customer.addRentalUnit(secondRental);
		customer.addRentalUnit(thirdRental);
		customer.checkout();
	}

}