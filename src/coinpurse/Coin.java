package coinpurse;

/**
 * a coin with a monetary value and currency. You can get coin, check that it is
 * equal or not by checking a currency and the value. It can also comparing
 * between a coin.
 * 
 * @author Narut Poovorakit
 * @version 19.02.2017
 */
public class Coin extends AbstractValuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	
	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is a value of the coin.
	 */
	public Coin(double value) {
		super(value);
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
		super(value, currency);
	}

	/**
	 * Print the whole message of the coin, contain the value and currency.
	 */
	public String toString() {
		return value + "-" + currency;
	}

}
