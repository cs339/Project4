
public class runner {

	public static void main(String[] args) {
		NewReleaseMovie firstMovie = new NewReleaseMovie("Movie 1");
		ChildrensMovie secondMovie = new ChildrensMovie("Movie 2");
		RegularMovie thirdMovie = new RegularMovie("Movie 3");
		Rental firstRental = new Rental(firstMovie, 2);
		Rental secondRental = new Rental(secondMovie, 2);
		Rental thirdRental = new Rental(thirdMovie, 2);
		Customer customer = new Customer("Joe");
		customer.addRental(firstRental);
		customer.addRental(secondRental);
		customer.addRental(thirdRental);
		customer.checkout();
	}

}
