package coinpurse;

import java.util.Scanner;

/**
 * User Interface for the Coin Purse. This class provides simple interactive
 * dialog for inserting and removing money to/from the purse, and displaying the
 * balance.
 * 
 * @author Narut Poovorakit
 * 
 * @version 19.02.2017
 */
public class ConsoleDialog {
	// default currency for this dialog
	public String currency = "Baht";
	// use a single java.util.Scanner object for reading all input
	private static Scanner console = new Scanner(System.in);
	MoneyFactory factory;
	/** Purse that contain coin and currency */
	private Purse purse;

	/**
	 * Initialize a new Purse dialog.
	 * 
	 * @param purse
	 *            is the Purse to interact with.
	 */
	public ConsoleDialog(Purse purse) {
		this.purse = purse;
	}

	/** run the user interface */
	public void run() {
		String moneyChoice = "";
		String choice = "";
		System.out.println("Please choose the money type");
		System.out.println("enter t (thai), m (malay)");
		moneyChoice = console.nextLine().trim().toLowerCase();
		
		if (moneyChoice.equals("t")) {
			MoneyFactory.setMoneyFactory("thai");
			currency = "Baht";
		}
		else {
			MoneyFactory.setMoneyFactory("malay");
			currency = "Ringgit";
		}
		factory = MoneyFactory.getInstance();
		while (true) {
			System.out.printf("Purse contains %.2f %s\n", purse.getBalance(), currency);
			if (purse.isFull())
				System.out.println("Purse is FULL.");
			
			// print a list of choices
			System.out.print("\nPlease enter d (deposit), w (withdraw), ? (inquiry), or q (quit): ");
			choice = console.nextLine().trim().toLowerCase();

			if (choice.equals("d"))
				depositDialog();
			else if (choice.equals("w"))
				withdrawDialog();
			else if (choice.equals("?"))
				System.out.println(purse.toString());
			else if (choice.equals("q"))
				break; // leave the loop
			else
				System.out.println("\"" + choice + "\" is not a valid choice.");
		}
		// confirm that we are quitting
		System.out.println("Goodbye. The purse still has " + purse.getBalance() + " " + currency);
	}

	/**
	 * Ask the user how many valuable to deposit into purse, then deposit them.
	 * Show result of success or failure.
	 */
	public void depositDialog() {
		System.out.print("Enter value of valuable(s) to deposit on one line [eg: 5 5 1]: ");
		String inline = console.nextLine();
		// parse input line into numbers
		Scanner scanline = new Scanner(inline);
		while (scanline.hasNextDouble()) {
			double value = scanline.nextDouble();
				try {
					Valuable v = factory.createMoney(value);
					System.out.printf("Deposit %s... ", v.toString());
					boolean okValue = purse.insert(v);
					System.out.println((okValue ? "ok" : "FAILED"));
				} catch (IllegalArgumentException ex) {
					System.out.println("Sorry, " + value + " is not a valid amount.");
				}
		}
		if (scanline.hasNext())
			System.out.println("Invalid input: " + scanline.next());
	}
	/**
	 * Ask how much money (Baht) to withdraw and then do it. After withdraw,
	 * show the values of the valuable we withdrew.
	 */
	public void withdrawDialog() {
		System.out.print("How much to withdraw? ");
		if (console.hasNextDouble()) {
			double amount = console.nextDouble();
			Valuable[] vb = purse.withdraw(amount);
			if (vb == null)
				System.out.printf("Sorry, couldn't withdraw %g %s\n", amount, currency);
			else {
				System.out.print("You withdrew:");
				for (int k = 0; k < vb.length; k++) {
					System.out.print(" " + vb[k].toString());
				}
				System.out.println();
			}
		} else
			System.out.printf("Invalid amount.");
		// discard remainder of the input line so we don't read it again
		console.nextLine();
	}

}
