package coinpurse;

/**
 * a coin with a monetary value and currency. You can get coin, check that it is equal or not
 * by checking a currency and the value. It can also comparing between a coin.
 * 
 * @author Narut Poovorakit
 * @version 10.02.2017
 */
public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is a value of the coin.
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is a value of a coin.
	 * @param currency
	 *            is a currency of a coin.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return value of a coin.
	 * 
	 * @return value of a coin.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return currency of a coin.
	 * 
	 * @return currency of a coin.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check whether the object is equal to another or not based on value and currency.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		if (this.value == other.getValue() && this.currency.equals(other.getCurrency()))
			return true;
		else
			return false;
	}

	/**
	 * Comparing a coin to another coin based on value.
	 */
	@Override
	public int compareTo(Coin o) {
		if (value < o.getValue())
			return -1;
		if (value > o.getValue())
			return 1;
		return 0;
	}

	/**
	 * Print the whole message of the coin, contain the value and currency.
	 */
	public String toString() {
		return value + "-" + currency;
	}
}
