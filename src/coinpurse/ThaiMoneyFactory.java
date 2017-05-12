package coinpurse;

/**
 * 
 * @author Narut Poovorakit
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{
	@Override
	Valuable createMoney(double value) {
		if (value == 0.25 || value == 0.5)
			return new Coin(value * 100, "Satang coin");
		else if (value == 1 || value == 2 || value == 5 || value == 10)
			return new Coin(value, "Baht coin");
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			return new BankNote(value, "Baht");
		else
			throw new IllegalArgumentException();
	}

}
