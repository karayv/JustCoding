package my.coding.matrix;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for the task
 * 
 * Given an array of n integers, find the sum of the most common integer.
 * 
 * @author Andrey Karayvansky
 *
 */
public class SumOfCommon {

    /**
     * Get the sum of the most common integer in the array.
     * Example: (2,4,5,6,4) – return 8 (as 4+4 = 8). 
     * (1,2,1,3,1) – return 3 (as 1+1+1 = 3).
     * 
     * 
     * @param array
     * @return the sum
     */
    public BigInteger getSummOfCommon(int[] array) {

        if (array == null) {
            throw new NullPointerException("The argument should not be null.");
        }
        if (array.length == 0) {
            return BigInteger.ZERO;
        }
        if (array.length == 1) {
            return new BigInteger("" + array[0]);
        }

        Map<Integer, Integer> countsMap = new HashMap<>();
        
        populateCountsMap(array, countsMap);
        
        Integer key = findMaxCountKey(countsMap);
        
        return new BigInteger("" + key).multiply(new BigInteger("" + countsMap.get(key)));
    }

    private Integer findMaxCountKey(Map<Integer, Integer> countsMap) {
        int maxCount = 0;
        Integer res = null;
        for (Integer key : countsMap.keySet()) {
            Integer count = countsMap.get(key);
            //count should never be null
            if (count > maxCount) {
                maxCount = count;
                res = key;
            }
        }
        return res;
    }

    /**
     * Populate a map where keys are distinct values of the input array, values
     * show how often the key value appears in the input array.
     * 
     * @param array
     * @param countsMap
     */
    private void populateCountsMap(int[] array, Map<Integer, Integer> countsMap) {
        for (int elem : array) {
            Integer count = countsMap.get(elem);
            if (count == null) {
                countsMap.put(elem, 1);
            } else {
                countsMap.put(elem, ++count);
            }
        }
    }

}
