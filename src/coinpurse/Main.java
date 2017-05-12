package coinpurse;

import java.util.Arrays;
import java.util.List;
import java.util.Observer;

import coinpurse.gui.PurseObserver;
import coinpurse.gui.StatusObserver;
import coinpurse.strategy.RecursiveWithdraw;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Narut Poovorakit
 * @version 10.02.2017
 */
public class Main {

	private static int CAPACITY = 10;
	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		//Thai
//		System.out.println("THAI MONEY");
//		MoneyFactory factory = MoneyFactory.getInstance();
//		Valuable m = factory.createMoney(5);
//		System.out.println(m.toString());
//		Valuable m2 = factory.createMoney("1000.0");
//		System.out.println(m2.toString());
//		System.out.println("************");
		
//		//Malay
//		System.out.println("MALAY MONEY");
//		MoneyFactory malFactory = MoneyFactory.getInstance();
//		Valuable m3 = malFactory.createMoney(5);
//		System.out.println(m3.toString());
//		Valuable m4 = malFactory.createMoney(0.05);
//		System.out.println(m4.toString());
//		Valuable m5 = malFactory.createMoney("1000.0");
		Coin max = CoinUtil.max(new Coin(5), new Coin(10));
		System.out.println(max);
		
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(100, "Kip"));
		CoinUtil.sortByCurrency(coins);
		Purse purse = new Purse(CAPACITY);
		purse.setWithdrawStrategy(new RecursiveWithdraw());
		PurseObserver observer = new PurseObserver();
		StatusObserver statusObserver = new StatusObserver();
		purse.addObserver(observer);
		purse.addObserver(statusObserver);
		ConsoleDialog cd = new ConsoleDialog(purse);
		observer.run();
		statusObserver.run();
		cd.run();
	}
}
