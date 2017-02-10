package coinpurse;
 
/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	Coin one = new Coin(1);
    	Coin five = new Coin(5);
    	Coin malay = new Coin(0.5, "Ringgit");
    	System.out.println(one.toString());
    	System.out.println(one.compareTo(five));
    	System.out.println(five.compareTo(one));
    	System.out.println(one.equals(five));
//TODO follow the steps in the sequence diagram
        // 1. create a Purse

        // 2. create a ConsoleDialog with a reference to the Purse object

        // 3. run the ConsoleDialog

    }
}
