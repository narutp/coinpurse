package coinpurse;

/**
 * a banknote with a monetary value and currency. Banknote also contain a unique
 * serialnumber for each of the banknote.
 * 
 * @author Narut Poovorakit
 * @version 19.02.2017
 *
 */
public class BankNote implements Comparable<Valuable>, Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	private double value;
	private String currency;
	private long serialNumber;
	private static long nextSerialNumber = 1000000;

	/**
	 * A banknote with given default currency.
	 * 
	 * @param value
	 *            is a value of banknote.
	 */
	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
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
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get value of banknote.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get currency of banknote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check whether the banknote is same or not by checking the value and currency.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote banknote = (BankNote) obj;
		if (banknote.getCurrency().equals(this.getCurrency()) && banknote.getValue() == this.getValue())
			return true;
		else
			return false;
	}

	/**
	 * Comparing a banknote to another one by checking their value.
	 */
	@Override
	public int compareTo(Valuable v) {
		if (value < v.getValue())
			return -1;
		if (value > v.getValue())
			return 1;
		return 0;
	}

}
