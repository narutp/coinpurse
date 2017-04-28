package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * Recursive withdraw a money by determine all of the value in the purse not just picking
 * the most value. 
 * 
 * @author Narut Poovorakit
 * 
 * @version 28.04.2017
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/**
	 * Withdraw a money in the purse by using recursive withdraw.
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> list;
		if (amount == 0) {
			return new ArrayList<Valuable>();
		}
		if (money.isEmpty()) {
			return null;
		}
		if (amount >= money.get(0).getValue()) {
			list = withdraw(amount - money.get(0).getValue(), money.subList(1, money.size()));
			if (list != null) {
				list.add(money.get(0));
			}
		} else {
			list = withdraw(amount, money.subList(1, money.size()));
		}
		return list;
	}

}
