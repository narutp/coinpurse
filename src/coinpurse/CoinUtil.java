package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Narut Poovorakit
 * 
 * @version 19.02.2017
 */
public class CoinUtil {

	/**
	 * Method that examines all the valuable in a List and returns only the
	 * valuable that have a currency that matches the parameter value.
	 * 
	 * @param valuablelist
	 *            is a List of Valuable objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuablelist that
	 *         have the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuablelist, String currency) {
		List<Valuable> newValuableList = new ArrayList<Valuable>();
		for (Valuable valuable : valuablelist) {
			if (valuable.getCurrency().equals(currency)) {
				newValuableList.add(valuable);
			}
		}
		return newValuableList;
	}

	/**
	 * Method to sort a list of valuable by currency. On return, the list
	 * (valuable) will be ordered by currency.
	 * 
	 * @param valuable
	 *            is a List of valuable objects we want to sort.
	 *
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		Collections.sort(valuable, CompareByCurrency);
	}

	/**
	 * Sum valuable by currency and print the sum for each currency.
	 */
	public static void sumByCurrency(List<Valuable> valuable) {
		/** Old algorithm */
		// double sum = 0;
		// int check = 0;
		// String valuableCurrency = valuable.get(0).getCurrency(); // Get
		// currency from the parameter
		// String[] result = new String[valuable.size()];

		/**
		 * Check if there finish calculate the previous currency and continue
		 * the next currency
		 */
		// boolean firstDiffCurr = true;
		//
		// for (Valuable v : valuable) {
		// if (v.getCurrency().equalsIgnoreCase(valuableCurrency)) {
		// sum += v.getValue();
		// firstDiffCurr = true;
		// }
		// else {
		// result[check] = sum + " " + valuableCurrency + " ";
		// valuableCurrency = v.getCurrency();
		// sum = 0;
		// if (firstDiffCurr) {
		// sum += v.getValue();
		// firstDiffCurr = false;
		// }
		// check++;
		// }
		// }
		// /** Sum the last currency that didn't sum yet */
		// result[check] = sum + " " + valuableCurrency;
		//
		// for (int i = 0 ; i < check + 1 ; i++) {
		// System.out.print(result[i]);
		// }
		Map<String, Double> map = new HashMap<String, Double>();
		for (Valuable v : valuable) {
			if (map.containsKey(v.getCurrency())) {
				map.put(v.getCurrency(), map.get(v.getCurrency()) + v.getValue());
			} else {
				map.put(v.getCurrency(), v.getValue());
			}
		}
		System.out.println("Sum value");
		for (String s : map.keySet()) {
			System.out.println(map.get(s) + "-" + s);
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter valuables by currency of " + currency);
		List<Valuable> valuables = makeInternationalValuable();
		int size = valuables.size();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		List<Valuable> rupees = filterByCurrency(valuables, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (valuables.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort valuable by currency");
		valuables = makeInternationalValuable();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		sortByCurrency(valuables);
		System.out.print("RESULT: ");
		printList(valuables, " ");

		System.out.println("\nSum valuable by currency");
		valuables = makeInternationalValuable();
		System.out.print("valuables= ");
		printList(valuables, " ");
		sumByCurrency(valuables);

	}

	/** Make a list of valuables containing different currencies. */
	public static List<Valuable> makeInternationalValuable() {
		List<Valuable> vb = new ArrayList<Valuable>();
		vb.addAll(makeCoin("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		vb.addAll(makeCoin("Ringgit", 2.0, 50.0, 1.0, 5.0));
		vb.addAll(makeCoin("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(vb);
		return vb;
	}

	/** Make a list of valuables using given values. */
	public static List<Valuable> makeCoin(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values) {
			list.add(new Coin(value, currency));
		}
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}

	/**
	 * Comparing the valuable by a currency.
	 */
	static Comparator<Valuable> CompareByCurrency = new Comparator<Valuable>() {
		@Override
		public int compare(Valuable o1, Valuable o2) {
			return o1.getCurrency().compareTo(o2.getCurrency());
		}
	};
}
