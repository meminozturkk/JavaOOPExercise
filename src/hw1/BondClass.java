package hw1;

/*
 * That class extends AssetClass for bond transaction
 * @Author: Muhammet Emin Ozturk
 */
public class BondClass extends AssetClass {

	// they are fields for principle, interest rate and number of the bonds owned.
	private double principle;
	private double interestRate;
	private int NumberOwned = 0;

	// that is constructor class takes three inputs name of the bond, a principal
	// and interest rate.
	// @param name the name of the Bond
	// @param principle the principle of the bond
	// @param interest rate the interest rate of the bond
	public BondClass(String name, double principle, double interestRate) {
		super(name, 0);
		this.principle = principle;
		setCurrentPrice(principle);
		this.interestRate = interestRate;

	}

	// they are getters and setters methods.
	public double getPrinciple() {
		return principle;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getNumberOwned() {
		return NumberOwned;
	}

	public void setNumberOwned(int numberOwned) {
		NumberOwned = numberOwned;
	}

	// pays interest
	// @return interest
	public double payInterest() {

		return interestRate * principle;

	}

	// the method purchase a bond
	public double buy() {
		setCostBasis(getCurrentPrice());
		setNumberOwned(getNumberOwned() + 1);
		return getCurrentPrice();
	}

	// the method sells a bond
	// @return the Current Price or 0
	public double sell() {
		// if there is no any bond
		if (getNumberOwned() == 0) {
			return 0;
		} else {

			// the capital gains are increased by the difference between the current price
			setCapitalGains(getCapitalGains() + (getCurrentPrice() - getCostBasis()));
			// the cost basis are reduced by(cost basis/number of bonds owned)
			setCostBasis(getCostBasis() - (getCostBasis() / getNumberOwned()));
			// the number of bonds owned are decreased by 1
			setNumberOwned(getNumberOwned() - 1);
			return getCurrentPrice();
		}

	}

}
