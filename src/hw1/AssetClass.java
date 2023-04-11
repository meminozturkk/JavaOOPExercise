package hw1;

/*
 * That is a base class that represents any tangible property that has a value.
 * 
 * @Author: Muhammet Emin Ozturk
 */
public class AssetClass {

	// they are fields for name, description,cost,current price and capital gains.
	private String name;
	private String assetDescription;
	private double costBasis;
	private double currentPrice;
	private double capitalGains;

	// Constructs a new Asset object with the given name and cost basis
	//@param name the name of asset
	//@param cost basis the cost basis of the asset
	public AssetClass(String name, double costBasis) {
		this.name = name;
		this.costBasis = costBasis;
		capitalGains = 0;
	}

	// they are getters and setters.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public double getCostBasis() {
		return costBasis;
	}

	public void setCostBasis(double costBasis) {
		this.costBasis = costBasis;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getCapitalGains() {
		return capitalGains;
	}

	public void setCapitalGains(double capitalGains) {
		this.capitalGains = capitalGains;
	}

}
