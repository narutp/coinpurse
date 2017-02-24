package coinpurse;
 

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse.
 * This is a JUnit 4 test.  
 * To run these tests, right click on this file (in Navigator pane)
 * and choose Run As -> JUnit test
 * @author  Resident Evil
 * @version 2017.02.01
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /** Easy test that the Purse constructor is working. */
    @Test
    public void testConstructor()
    {
        Purse purse = new Purse(3);
        assertEquals(3, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }

    

    /** Insert some Valuables. Easy test. */
    @Test
    public void testInsert()
    {
        Purse purse = new Purse(3);
        Valuable Valuable1 = new Coin(5);
        Valuable Valuable2 = new Coin(10);
        Valuable Valuable3 = new Coin(1);
        assertTrue( purse.insert(Valuable1));
        assertTrue( purse.insert(Valuable3));
        assertTrue( purse.insert(Valuable2));
        assertEquals( 3, purse.count() );
        // purse is full so insert should fail
        assertFalse( purse.insert(new Coin(1)) );
    }
    

    /** Insert should reject Valuable with no value. */
    @Test
    public void testInsertNoValue()
    {
        Purse purse = new Purse(3);
        Valuable fakeValuable = new Coin(0);
        assertFalse( purse.insert(fakeValuable));
    }


    @Test
    public void testIsFull()
    {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse( purse.isFull() );
        purse.insert( new Coin(1) );
        assertTrue( purse.isFull() );
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for(int k=1; k<=capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert( new Coin(k) );
        }
        // full now
        assertTrue( purse.isFull() );
        assertFalse( purse.insert( new Coin(5) ) );
    }

	/** Should be able to insert same Valuable many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test
	public void testInsertSameValuable()
	{
		Purse purse = new Purse(5);
		Valuable Valuable = new Coin(10);
		assertTrue( purse.insert(Valuable) );
		assertTrue( purse.insert(Valuable) ); // should be allowed
		assertTrue( purse.insert(Valuable) ); // should be allowed
	}

	@Test
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		int [] values = {1, 10, 1000};
		for(int value : values) {
			Valuable Valuable = new Coin(value);
			assertTrue(purse.insert(Valuable));
			assertEquals(value,  purse.getBalance(), TOL);
			Valuable [] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  Valuable, result[0] );
			assertEquals( 0, purse.getBalance(), TOL );
		}
	}

	@Test
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		int value = 1;
		double amount1 = 0;
		double amount2 = 0;
		for(int k=1; k<10; k=k+2)  {
			assertTrue( purse.insert( new Coin(value)) );
			amount1 += value;
			value = 2*value;
			assertTrue( purse.insert( new Coin(value)) );
			amount2 += value;
			value = 2*value;
		}
		assertEquals(amount1+amount2, purse.getBalance(), TOL );
		assertEquals(10, purse.count() );
		Valuable [] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sumValue(wd1), TOL );
		assertEquals(amount2, purse.getBalance(), TOL );
		Valuable [] wd2 = purse.withdraw(amount2);
		assertEquals(0, purse.getBalance(), TOL );
	}

	@Test
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull( purse.withdraw(1) );
		purse.insert( new Coin(20) );
		assertNull( purse.withdraw(1) );
		assertNull( purse.withdraw(19) );
		assertNull( purse.withdraw(21) );
		purse.insert( new Coin(20) );
		assertNull( purse.withdraw(30) );
	}
	
	/**
	 * Sum the value of some Valuables.
	 * @param Valuables array of Valuables
	 * @return sum of values of the Valuables
	 */
	private double sumValue(Valuable [] Valuables)  {
		if (Valuables == null) return 0;
		double sum = 0;
		for(Valuable v: Valuables) if (v != null) sum += v.getValue();
		return sum;
	}
}


