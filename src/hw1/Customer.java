package hw1;

/*
 * That class for customer transaction 
 * @Author: Muhammet Emin Ozturk
 */

public class Customer {

	//they are fields for first name of the customer, last name of the customer, 
	//bond class for the bond of the customer, mutual fund for the mutual fund of the customer
	//and customers` total cash
	private String firstName;
	private String lastName;
	private BondClass bond;
	private MutualFund mutualFund;
	private double totalCash;

	/*
	 * constructs a new Customer given with bond, mutual fund , first name, last name and total cash
	 * @param bond the bond of the customer
	 * @param mutualFund the mutual fund of the customer
	 * @param firstName the first name of the customer
	 * @param lastName the last name of the customer
	 * @param totalCash the total cash of the customer
	 */
	public Customer(BondClass bond, MutualFund mutualFund, String firstName, String lastName, double totalCash) {
		this.bond = bond;
		this.mutualFund = mutualFund;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalCash = totalCash;
	}

	//they are getters and setters methods.
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BondClass getBond() {
		return bond;
	}

	public void setBond(BondClass bond) {
		this.bond = bond;
	}

	public MutualFund getMutualFund() {
		return mutualFund;
	}

	public void setMutualFund(MutualFund mutualFund) {
		this.mutualFund = mutualFund;
	}

	// return total amount of money
	// @return a number calculated
	public double cuurentValue() {
		if (bond.getNumberOwned() != 0 || mutualFund.getNumberShares() != 0) {
			return bond.getCurrentPrice() * bond.getNumberOwned()
					+ mutualFund.getNumberShares() * mutualFund.getCurrentPrice();
		}
		return 0;
	}

	//return all capital gains
	//@return a number calculated
	public double getCapitalGains() {
		if (bond.getCapitalGains() != 0 || mutualFund.getCapitalGains() != 0) {
			return bond.getCapitalGains() + mutualFund.getCapitalGains();
		}
		return 0;

	}

	//sells bond of customer owned
	public void sellBond() {
		bond.sell();
		totalCash += bond.getCurrentPrice();

	}
	/*
	 * buys bond 
	 * @return true/false - by amount of total cash
	 */
	public boolean buyBond() {
		if (totalCash < bond.getCurrentPrice()) {
			return false;
		} else {
			bond.buy();
			totalCash -= bond.getCurrentPrice();
			return true;
		}
	}
	//sells mutual fund of customer owned
	//@param amount the amount of the selling mutual fund money
	public void withdrawMutualFund(double amount) {
		mutualFund.sell(amount);
		totalCash += amount;

	}
	/*
	 * buys mutual fund 
	 * @param amountOfMutual the amount of the mutual fund
	 * @return true/false - by amount of total cash
	 */
	public boolean buyMutualFund(double amountOfMutual) {
		if (amountOfMutual > totalCash) {
			return false;
		} else {
			mutualFund.buy(amountOfMutual);
			totalCash -= amountOfMutual;
			return true;
		}
	}

}
