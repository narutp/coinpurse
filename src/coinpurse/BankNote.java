package coinpurse;

/**
 * a banknote with a monetary value and currency. Banknote also contain a unique
 * serialnumber for each of the banknote.
 * 
 * @author Narut Poovorakit
 * @version 19.02.2017
 *
 */
public class BankNote extends AbstractValuable{
	private long serialNumber;
	private static long nextSerialNumber = 1000000;

	/**
	 * A banknote with given default currency.
	 * 
	 * @param value
	 *            is a value of banknote.
	 */
	public BankNote(double value) {
		super(value);
		this.serialNumber = this.nextSerialNumber + 1;
		this.nextSerialNumber = this.serialNumber;
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 *            is a value of banknote.
	 * @param currency
	 *            is a currency of banknote.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = this.nextSerialNumber + 1;
		this.nextSerialNumber = this.serialNumber;
	}

	/**
	 * Print the whole message of the coin, contain the value and currency.
	 */
	public String toString() {
		return value + "-" + currency + " note [" + serialNumber + "]";
	}

}
