package hw1;

/*
 * That class extends AssetClass for equity transaction
 * @Author: Muhammet Emin Ozturk
 */

public class EquityClass extends AssetClass {

	//they are fields for symbol of the equity and number of the shares owned of the equity
	private char symbol;
	private double numberShares;
	/*
	 * Constructs a new Equity object with the given name, symbol and current price
	 * @param name the name of the Equity 
	 * @param symbol the symbol of the Equity
	 * @param current price the current price of the Equity
	 */
	public EquityClass(String name, char symbol, double currentPrice) {
		super(name, 0);
		this.symbol = symbol;
		setCurrentPrice(currentPrice);

	}

	//they are getters and setters
	public double getNumberShares() {
		return numberShares;
	}

	public void setNumberShares(double numberShares) {
		this.numberShares = numberShares;
	}

	public char getSymbol() {
		return symbol;
	}

}
