package coinpurse;

public class AbstractValuable implements Valuable {

	public static final String DEFAULT_CURRENCY = "Baht";
	double value;
	String currency;

	public AbstractValuable(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Check whether the banknote is same or not by checking the value and
	 * currency.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		AbstractValuable av = (AbstractValuable) obj;
		if (av.getCurrency().equals(this.currency) && av.getValue() == this.value)
			return true;
		else
			return false;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	@Override
	public int compareTo(Valuable v) {
		if (value < v.getValue())
			return -1;
		if (value > v.getValue())
			return 1;
		return 0;
	}

}