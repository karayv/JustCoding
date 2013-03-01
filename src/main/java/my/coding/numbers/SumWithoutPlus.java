package my.coding.numbers;

/**
 * Test for finding sum without arithmetic operations like + or -.
 * 
 * @author Andrey Karayvansky
 *
 */
public class SumWithoutPlus {

    /** 
     * Fast and simple implementation for two integers.
     * 
     * @param int1
     * @param int2
     * @return the sum of arguments
     */
    public int sum(int int1, int int2) {
        if (int1 == 0) {
            return int2;
        }
        if (int2 == 0) {
            return int1;
        }
        
        int xorSum = int1 ^ int2;
        int addition = (int1 & int2) << 1;
        return sum(xorSum, addition);
    }
    
    /**
     * Heavy implementation. Kept for children :)
     * 
     * @param int1
     * @param int2
     * @return the sum
     */
    public int sum2(int int1, int int2) {
        if (int1 == 0) {
            return int2;
        }
        if (int2 == 0) {
            return int1;
        }

        int index = 1;
        
        int sh = ~0;
        
        int addition = 0;
        int sum = 0;
        
        while (sh != 0) {
            int low1 = int1 & index;
            int low2 = int2 & index;

            int lowSum = low1 ^ low2 ^ addition;
            
            sum = sum | lowSum;
            
            addition = (low1 & low2 | low1 & addition | low2 & addition) << 1;

            index = index << 1;
            
            sh = sh >>> 1;
        }
        return sum;
    }

}
