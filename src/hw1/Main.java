package hw1;

public class Main {

	public static void main(String[] args) {

		// test of asset class
		// using constructor for asset
		AssetClass asset = new AssetClass("hisse1", 10);
		// return name of asset
		System.out.println(asset.getName()); // return hisse1
		// set name of asset
		asset.setName("hisse2");
		// return hisse2
		System.out.println(asset.getName());
		// set capital gains
		asset.setCapitalGains(100); // set 100
		System.out.println(asset.getCapitalGains());// return is 100

		// test of bond class
		// using constructor for bond
		BondClass bond = new BondClass("bond hisse 1", 10.5, 0.3);
		System.out.println(bond.getName());// print bond hisse 1
		System.out.println(bond.getPrinciple());// print 10.5
		System.out.println(bond.getInterestRate());// print 20.3
		System.out.println(bond.getCostBasis());// print 0
		// buy a bond and increase cost
		bond.buy();
		System.out.println(bond.getNumberOwned());// print 1
		System.out.println(bond.getCostBasis());// print 10.5
		bond.setCurrentPrice(11);
		System.out.println(bond.getCurrentPrice());// 11
		// sell a bond and decrease cost and increase capital gains
		// as current price mines - principle
		System.out.println(bond.getCapitalGains());// print 0.0
		bond.sell();
		System.out.println(bond.getNumberOwned());// print 0
		System.out.println(bond.getCapitalGains());// print 0.5
		System.out.println(bond.payInterest());// print 3.15 (0.3 * 10.5)

		// test of equity class
		EquityClass equity = new EquityClass("Equinty", 'S', 12);
		System.out.println(equity.getSymbol());// print S
		// set numberShares as 5
		equity.setNumberShares(5);
		System.out.println(equity.getNumberShares());// print 5

		// test of mutualfund
		
		MutualFund mutual = new MutualFund("mutual hisse", 'P', 13);
		mutual.setLoad(10);// set load as 10
		System.out.println(mutual.getName());// print mutual hisse
		System.out.println(mutual.getSymbol());// print P
		System.out.println(mutual.getCurrentPrice());// print 13
		System.out.println(mutual.getNumberShares());// 0
		System.out.println(mutual.buy(0));// print 0
		System.out.println(mutual.buy(130));// print 130
		System.out.println(mutual.getCostBasis());// print 130
		mutual.setCurrentPrice(15);
		System.out.println(mutual.getCurrentPrice());// print 15
		System.out.println(mutual.getNumberShares());// print 9
		System.out.println(mutual.sell(0));// print 0
		System.out.println(mutual.sell(67.5));// print 67.5
		System.out.println(mutual.getNumberShares());// print 4.5
		System.out.println(mutual.getCostBasis());// print 65
		System.out.println(mutual.getCapitalGains());// print 2.5
		
		//test of customer
		Customer customer = new Customer(bond, mutual, 
				"Muhammet Emin", "Ozturk", 500);
		System.out.println(customer.getFirstName());//print Muhammet Emin
		System.out.println(customer.getLastName());//print Ozturk
		System.out.println(customer.getBond().getClass());//print class hw1.BondClass
		customer.setBond(bond);
		System.out.println(customer.getBond().getName());//print bond hisse 1
		System.out.println(customer.getMutualFund().getClass());//print class hw1.MutualFund
		customer.setMutualFund(mutual);
		System.out.println(customer.getMutualFund().getName());// print mutual hisse
		System.out.println(customer.cuurentValue());//print 67.5
		System.out.println(customer.getCapitalGains());//print 3
		customer.buyBond();
		System.out.println(customer.cuurentValue());//print 78.5
		customer.sellBond();
		System.out.println(customer.cuurentValue());//print 67.5
		customer.withdrawMutualFund(800);//doing nothing
		customer.withdrawMutualFund(2);
		System.out.println(customer.cuurentValue());//print 65.5
		customer.buyMutualFund(500);
		System.out.println(customer.cuurentValue());//print 515.5
		customer.buyMutualFund(10000);//doing nothing, return 0
		System.out.println(customer.cuurentValue());//print 515.5
		
	
	}

}
