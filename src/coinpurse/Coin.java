package coinpurse;

//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency
 * 
 * @author
 */
// TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable<Coin>{
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.currency;
	}

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

	public String toString() {
		return value + "-" + currency;
	}

	@Override
	public int compareTo(Coin o) {
		if (value < o.getValue())
			return -1;
		if (value > o.getValue())
			return 1;
		return 0;
	}

}
