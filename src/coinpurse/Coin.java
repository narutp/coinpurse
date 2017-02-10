package coinpurse;
//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency
 * @author
 */
//TODO declare that Coin implements Comparable<Coin>
public class Coin {
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
        
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
 
    }

//TODO Write a getValue() method and javadoc.
    public double getValue( ) { } 
    
//TODO Write a getCurrency() method and javadoc.
    public String getCurrency() { }
    
//TODO Write an equals(Object) method.
    public boolean equals(Object obj) {

    }
    
//TODO Write a compareTo method and implement Comparable.
    
//TODO write a toString() method. See labsheet for what to return.
    public String toString() { return ""; }
    
//TODO Write good Javadoc comments on all methods.
    
}
//TODO remove the TODO comments after you complete them! Including this one!
