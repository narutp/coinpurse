package coinpurse;

import java.util.Arrays;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author your name
 */
public class Main {

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Coin one = new Coin(1);
		Coin five = new Coin(5);
		Coin malay = new Coin(0.5, "Ringgit");
		System.out.println(one.toString());
		System.out.println(one.compareTo(five));
		System.out.println(five.compareTo(one));
		System.out.println(one.equals(five));
		System.out.println("*****************************");
		Purse purse = new Purse(3);
		System.out.println("Balance: " + purse.getBalance());
		System.out.println("Count: " + purse.count());
		System.out.println("Is it full?: " + purse.isFull());
		System.out.println("Insert 5: " + purse.insert(new Coin(5)));
		System.out.println("Insert 10: " + purse.insert(new Coin(10)));
		System.out.println("Insert 0: " + purse.insert(new Coin(0)));
		System.out.println("Insert 1: " + purse.insert(new Coin(1)));
		System.out.println("Insert 5: " + purse.insert(new Coin(5)));
		System.out.println("How much coin?: " + purse.count());
		System.out.println("Is it full?: " + purse.isFull());
		System.out.println("Balance: " + purse.getBalance());
		System.out.println(purse.toString());
		System.out.println("Withdraw: " + Arrays.toString(purse.withdraw(6)));
		System.out.println("Withdraw: " + Arrays.toString(purse.withdraw(10)));

		// TODO follow the steps in the sequence diagram
		// 1. create a Purse

		// 2. create a ConsoleDialog with a reference to the Purse object

		// 3. run the ConsoleDialog

	}
}
