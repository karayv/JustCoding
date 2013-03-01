package my.coding;

import java.util.HashSet;
import java.util.Set;

public class ZeroCrosses {

    public int[][] drawZeroCrosses(int[][] inp) {
        if (inp == null) throw new NullPointerException("Null is not allowed.");
        Set<Integer> xZeros = new HashSet<>();
        Set<Integer> yZeros = new HashSet<>();

        for (int x = 0; x < inp.length; x++) {
            for (int y = 0; y < inp[x].length; y++) {
                if (inp[x][y] == 0) {
                    xZeros.add(x);
                    yZeros.add(y);
                }
            }
        }

        for (Integer x : xZeros) {
            for (int i = 0; i < inp[x].length; i++) {
                inp[x][i] = 0;
            }
        }
        for (int i = 0; i < inp.length; i++) {
            for (Integer y : yZeros) {
                inp[i][y] = 0;
            }
        }

        return inp;
    }

}
