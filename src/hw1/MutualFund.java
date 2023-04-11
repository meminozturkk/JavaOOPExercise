package hw1;
/*
 * That class extends EquityClass for equity transaction
 * @Author: Muhammet Emin Ozturk
 */
public class MutualFund extends EquityClass {
	//the field stores the load of the fund.
	private double load;
	/*
	 * Constructs a new Mutual fund object with the given name, symbol, current price
	 * @param name the name of the MutualFund 
	 * @param symbol the symbol of the MutualFund
	 * @param currentprice the current price of the MutualFund
	 */
	public MutualFund(String name, char symbol, double currentPrice) {
		super(name, symbol, currentPrice);
	}

	//they are getter and setter
	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		this.load = load;
	}
	/*
	 * buys a mutual fund
	 * @param amount of money for buying mutual fund
	 * @return double number that is amount of money
	 */
	public double buy(double amountOfMoney) {
		if (amountOfMoney <= 0) {
			return 0;
		} else {
			setNumberShares(getNumberShares() + (amountOfMoney * ((100 - getLoad()) / 100) / getCurrentPrice()));
			setCostBasis(getCostBasis() + amountOfMoney);
			return amountOfMoney;
		}

	}

	/*
	 * sells a mutual fond
	 * @param amount of withdraw
	 * @return a number of amount of withdraw
	 */
	public double sell(double withdraw) {

		if (withdraw <= 0 || withdraw > (getCurrentPrice() * getNumberShares())) {
			return 0;
		} else {
			// sold number of shares
			double soldNumberShares = withdraw / getCurrentPrice();
			// The cost basis is decreased by the ratio of the number of shares sold to the
			// number of shares owned prior to this sale
			double ratioOfNumberShares = (soldNumberShares / getNumberShares());
			// the number of shares owned is decreased by amount withdrawn / current price
			setNumberShares(getNumberShares() - soldNumberShares);

			setCostBasis(getCostBasis() - (getCostBasis() * ratioOfNumberShares));

			// The capital gains is increased by the difference between the amount withdrawn
			// and the amount that the cost basis decreased.

			setCapitalGains(getCapitalGains() + (withdraw - getCostBasis()));

			return withdraw;
		}

	}
}
