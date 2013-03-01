package my.coding.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Test for task.
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 * 
 * @author Andrey Karayvansky
 *
 */
public class ZeroCrosses {

    /**
     * Return an array where entire row and column is set to 0 for every zero element.
     * 
     * @param inp array
     * @return modified array
     */
    public int[][] drawZeroCrosses(int[][] inp) {
        if (inp == null) throw new NullPointerException("Null is not allowed.");
        
        Set<Integer> xZeros = new HashSet<>();
        Set<Integer> yZeros = new HashSet<>();

        // find zero elements and populate sets of zero indexes.
        for (int x = 0; x < inp.length; x++) {
            for (int y = 0; y < inp[x].length; y++) {
                if (inp[x][y] == 0) {
                    xZeros.add(x);
                    yZeros.add(y);
                }
            }
        }

        // update rows
        for (Integer x : xZeros) {
            for (int i = 0; i < inp[x].length; i++) {
                inp[x][i] = 0;
            }
        }
        // update columns
        for (int i = 0; i < inp.length; i++) {
            for (Integer y : yZeros) {
                inp[i][y] = 0;
            }
        }

        return inp;
    }

}
