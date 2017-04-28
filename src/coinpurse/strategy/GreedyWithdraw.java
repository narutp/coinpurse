package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import coinpurse.Valuable;

/**
 * Greedy withdraw a money in the purse by using greedy way or withdraw the biggest 
 * value of money first.
 * 
 * @author Narut Poovorakit
 * 
 * @version 28.04.2017
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{

	/**
	 * Withdraw a money by choose the most value in the purse first.
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		double tmpCoin;
		List<Valuable> tmpMoney = new ArrayList<Valuable>(money);
		List<Valuable> withdraw = new ArrayList<Valuable>();
		Valuable[] arr;
		if (amount > 0) {
			for (Valuable v : money) {
				if (v.getValue() <= amount) {
					tmpCoin = v.getValue();
					withdraw.add(v);
					tmpMoney.remove(v);
					amount -= tmpCoin;
				}
			}
			if (amount != 0) {
				return null;
			} else {
				money = new ArrayList<Valuable>(tmpMoney);
			}
		} else {
			return null;
		}
		for (int i = 0 ; i < money.size() ; i++) {
			System.out.println(money.get(i).getValue());
		}
		arr = new Valuable[withdraw.size()];
		return withdraw;
	}

}
