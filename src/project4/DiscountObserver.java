package project4;

public class DiscountObserver extends RentalObserver{
	private int numRentals = 0;
	
	public DiscountObserver(Customer customer) {
		this.customer = customer;
	}
	@Override
	public void addRental() {
		numRentals++;
	}

	@Override
	public double getDiscount() {
		if (numRentals < 3) {
			System.out.println("Discount: 1.0");
			return 1.0;
		}
		else if (numRentals > 5){
			System.out.println("Discount: 0.5");
			return 0.5;
		}
		else {
			System.out.println("Discount: 0.8");
			return 0.8;
		}
	}
	@Override
	public void resetRentals() {
		numRentals = 0;
	}
}
