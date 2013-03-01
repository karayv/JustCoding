package my.coding.factorial;

import static org.junit.Assert.*;

import java.math.BigInteger;

import my.coding.factorial.FactorialSplitRecursive;

import org.junit.Test;

/**
 * Tests factorial calculation.
 * 
 * @author Andrey Karayvansky
 *
 */
public class FactorialSplitRecursiveTest {

    FactorialSplitRecursive service = new FactorialSplitRecursive();
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeArg() {
        service.getFactorial(-1);
    }

    @Test
    public void testFactorialFunction() {
        assertEquals(BigInteger.ONE, service.getFactorial(0));
        assertEquals(new BigInteger("120"), service.getFactorial(5));
        assertEquals(new BigInteger("3628800"), service.getFactorial(10));
        assertEquals(new BigInteger("1307674368000"), service.getFactorial(15));
        assertEquals(new BigInteger("2432902008176640000"), service.getFactorial(20));
        assertEquals(new BigInteger("51090942171709440000"), service.getFactorial(21));
    }

}
