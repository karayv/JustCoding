package my.coding.aws;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SumOfCommon {

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
