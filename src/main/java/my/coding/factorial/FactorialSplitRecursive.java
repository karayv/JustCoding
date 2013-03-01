package my.coding.factorial;

import java.math.BigInteger;

/**
 * This class implements Split Recursive algorithm from
 * <a>http://www.luschny.de/math/factorial/FastFactorialFunctions.htm</a>. This
 * is improved splitting algorithm where we do the actual splitting only for odd
 * denominators. All multiplies by two are done using binary shift.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class FactorialSplitRecursive {

    /**
     * Calculate factorial of a number.
     * 
     * @param n the number to get factorial from
     * @return the resulting value
     * @throws IllegalArgumentException if the argument is less than zero
     */
    public BigInteger getFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial from negative number.");
        }
        if (n < 2) {
            return BigInteger.ONE;
        }
        BigInteger p = BigInteger.ONE;
        BigInteger r = BigInteger.ONE;
        
        SplitOdd helper = new SplitOdd();
        
        int h = 0, shift = 0, high = 1;
        int log2n = (int)Math.floor(Math.log(n)/Math.log(2));
        
        while (h != n) {
            shift += h;
            h = n >> log2n--;
            int len = high;
            high = (h - 1) | 1;
            len = (high - len) / 2;
            if (len > 0) {
                p = p.multiply(helper.product(len));
                r = r.multiply(p);
            }
         }
         return r.shiftLeft(shift);
    }

    /**
     * A helper class to to populate all the odd denominators.
     *
     */
    private class SplitOdd {

        private int currentN = 1;
        
        /**
         * Get a product next of a next portion of odd denominators.
         * 
         * @param n
         * @return
         */
        private BigInteger product(int n) {
            int m = n / 2;
            
            if (m == 0) {
                currentN += 2;
                return BigInteger.valueOf(currentN);
            } 
            if (n == 2) {
                currentN += 4;
                return BigInteger.valueOf((currentN * (currentN - 2)));
            }
            return product(n - m).multiply(product(m));
        }
    }
    
}
