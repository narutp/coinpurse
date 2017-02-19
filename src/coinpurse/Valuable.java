package coinpurse;

/**
 * A valuable that have currency and value of their own.
 * @author Narut Poovorakit
 * 
 * @version 19.02.2016
 *
 * @param <T>
 */
public interface Valuable<T> {
	
	public double getValue();
	public String getCurrency();
}
