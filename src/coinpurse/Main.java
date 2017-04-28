package coinpurse;

import java.util.Arrays;
import java.util.Observer;

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
		
		Purse purse = new Purse(CAPACITY);
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
