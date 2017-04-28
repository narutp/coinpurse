package strategy;

import java.util.List;

import coinpurse.Valuable;

public interface WithdrawStrategy {
	
	public void withdraw(double amount, List<Valuable> valuables);
}
