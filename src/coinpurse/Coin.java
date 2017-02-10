package coinpurse;

//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency
 * 
 * @author
 */
// TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable{
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

	// TODO Write a getValue() method and javadoc.
	public double getValue() {
		return this.value;
	}

	// TODO Write a getCurrency() method and javadoc.
	public String getCurrency() {
		return this.currency;
	}

	// TODO Write an equals(Object) method.
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

	// TODO write a toString() method. See labsheet for what to return.
	public String toString() {
		return "";
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	// TODO Write good Javadoc comments on all methods.

}
// TODO remove the TODO comments after you complete them! Including this one!
