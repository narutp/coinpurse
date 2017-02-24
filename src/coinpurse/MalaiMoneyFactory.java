package coinpurse;

public class MalaiMoneyFactory extends MoneyFactory{

	@Override
	Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5)
			return new Coin(value * 100, "Sen coin");
		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
			return new BankNote(value, "Ringgit banknote");
		else
			throw new IllegalArgumentException();
	}

}
