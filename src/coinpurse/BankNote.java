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

	/**
	 * A banknote with given default currency.
	 * 
	 * @param value
	 *            is a value of banknote.
	 */
	public BankNote(double value) {
		super(value);
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
	}
	
	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 *            is a value of banknote.
	 * @param currency
	 *            is a currency of banknote.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Print the whole message of the coin, contain the value and currency.
	 */
	public String toString() {
		return value + "-" + currency + " note [" + serialNumber + "]";
	}

}
