package my.coding.shuffle;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Helper class for tasks where shuffling is required.
 * 
 * @author Andrey Karayvansky
 *
 */
public class Shuffle {

    /**
     * Shuffles the integer array. Optimized for used by multiple threads.
     * 
     * @param array integer array
     * @return shuffled input array
     */
    public static int[] shuffleIntArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int rndInd = ThreadLocalRandom.current().nextInt(i, array.length);
            swap(array, i, rndInd);
        }
        return array;
    }

    /**
     * Swaps two integers in array.
     * 
     * @param array the array
     * @param ind1
     * @param ind2
     */
    public static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

}
