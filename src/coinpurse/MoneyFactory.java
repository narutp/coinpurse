package coinpurse;

public abstract class MoneyFactory {

	private static MoneyFactory factory ;
	
	static MoneyFactory getInstance() {
		if (factory == null)
			factory = new MalaiMoneyFactory();
		return factory;
	}
	
	abstract Valuable createMoney(double value);
	
	Valuable createMoney(String value) {
		double money = 0;
		money = Double.parseDouble(value);
		return createMoney(money);
	}
	
	static void setMoneyFactory(String s) {
		if (s.equalsIgnoreCase("thai")) {
			factory = new ThaiMoneyFactory();
		}
		else if (s.equalsIgnoreCase("malay"))
			factory = new MalaiMoneyFactory();
	}
}
