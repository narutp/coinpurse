package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.RecursiveAction;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * A purse contains valuable. You can insert valuable, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the purse
 * decides which valuable to remove.
 * 
 * @author Narut Poovorakit
 * 
 * @version 19.02.2017
 */
public class Purse extends Observable {
	/** Collection of objects in the purse. */
	private List<Valuable> money;
	/** An overall value of valuable in the purse. */
	private double totalBalance;
	private WithdrawStrategy strategy;
	/**
	 * Capacity is maximum number of valuable the purse can hold. Capacity is
	 * set when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private String currency = "Baht";

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuable you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>(capacity);
	}

	/**
	 * Count and return the number of valuable in the purse. This is the number
	 * of valuable, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		totalBalance = 0;
		for (int i = 0; i < money.size(); i++) {
			totalBalance += money.get(i).getValue();
		}
		return totalBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String newCurrency) {
		this.currency = newCurrency;
	}

	/**
	 * Return the capacity of the valuable purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (count() < getCapacity())
			return false;
		return true;
	}

	/**
	 * Insert a valuable into the purse. The valuable is only inserted if the
	 * purse has space for it and the valuable has positive value. No worthless
	 * valuable!
	 * 
	 * @param valuable
	 *            is a valuable object to insert into purse
	 * @return true if valuable inserted, false if can't insert
	 */
	public boolean insert(Valuable v) {
		if (isFull() || v.getValue() <= 0)
			return false;
		money.add(v);
		setChanged();
		notifyObservers("Deposit" + v.toString());
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}
		/** Sort the list */
		Collections.sort(money, CompareByValue);
		Collections.reverse(money);
		
		List<Valuable> list = strategy.withdraw(amount, money);
		if (list == null) {
			return null;
		}
		for (Valuable v : list) {
			money.remove(v);
		}
		
		Valuable[] v = new Valuable[0];
		setChanged();
		notifyObservers("Withdrew" + amount);
		return list.toArray(v);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return count() + " coins with value " + totalBalance;
	}

	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Comparing the valuable.
	 */
	static Comparator<Valuable> CompareByValue = new Comparator<Valuable>() {
		@Override
		public int compare(Valuable v1, Valuable v2) {
			return v1.compareTo(v2);
		}
	};
}
