package my.coding.aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is a solution for the amazon coding task:
 * 
 * Given square matrix of N rows and N columns return array of N elements as
 * output, choosing them at random one from each row and one from each column.
 * Original matrix does not need to be preserved if it helps the solution.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class RandomVectorFromMatrix<T> {

    /**
     * Get the vector by the above requirements.
     * 
     * @param matrix the input matrix NxN
     * @return the resulting vector
     */
    public T[] getVector(T[][] matrix) {
        // check incorrect input
        if (matrix == null) {
            throw new NullPointerException("Input value cannot be null.");
        }
        checkThatMatrixIsSquare(matrix);
        
        Set<Integer> rowIndexesTaken = new HashSet<>();
        Set<Integer> columnIndexesTaken = new HashSet<>();
        
        List<T> resultList = new ArrayList<>(matrix.length);

        // do the logic
        for (int i = 0; i < matrix.length; i++) { 
            int columnIdx = getRandomFrom0toNExcludingTheSet(matrix.length, columnIndexesTaken);
            int rowIdx = getRandomFrom0toNExcludingTheSet(matrix.length, rowIndexesTaken);
            
            resultList.add(matrix[rowIdx][columnIdx]);
            
            rowIndexesTaken.add(rowIdx);
            columnIndexesTaken.add(columnIdx);
        }
        return resultList.toArray(Arrays.copyOfRange(matrix[0], 0, matrix[0].length));
    }

    private void checkThatMatrixIsSquare(T[][] matrix) {
        for (T[] vec : matrix) {
            if (vec.length != matrix.length) {
                throw new IllegalArgumentException("The input matrix should be square.");
            }
        }
    }

    private int getRandomFrom0toNExcludingTheSet(int n, Set<Integer> exclSet) {
        int rnd = (int) (Math.random() * (n - exclSet.size()));
        while (exclSet.contains(rnd)) {
            rnd++;
        }
        return rnd;
    }
}
