package project4;

public abstract class RentalObserver {
	protected Customer customer;
	
	public abstract void addRental();
	public abstract double getDiscount();
	public abstract void resetRentals();
}
