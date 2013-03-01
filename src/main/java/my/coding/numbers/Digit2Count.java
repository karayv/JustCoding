package my.coding.numbers;

/**
 * Task.
 * 
 * Count all digit 2 occurrences in a number.
 * 
 * @author Andrey Karayvansky
 *
 */
public class Digit2Count {

    /**
     * Counts how many times digit 2 appears in the number.
     * 
     * @param n the number
     * @return count of 2 occurrences
     */
    public int count2(int n) {
        int k1 = 1;
        int k2 = 10;
        
        // if negative, make positive
        if (n < 0) {
            n = -n;
        }
            
        int count = 0;
        int d, r;
        
        do {
            int decRightShift = n / k2;
            d = decRightShift * k1;
            
            int remain = (n - d * 10 - 2 * k1 + 1);
            
            remain = remain < 0 ? 0 : remain;
            r = remain < k1 ? remain : k1;

            k1 = k1 * 10;
            k2 = k2 * 10;
            
            count += d + r;
        } while (d != 0 || r != 0);
        return count;
    }

}
