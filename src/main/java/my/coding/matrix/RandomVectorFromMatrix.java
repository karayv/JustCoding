package my.coding.matrix;

import java.lang.reflect.Array;

import my.coding.shuffle.Shuffle;

/**
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
        
        // created arrays with indexes in values than shuffle them 
        int[] columnIndexesTaken = getIndexArray(matrix.length);
        int[] rowIndexesTaken = columnIndexesTaken.clone(); // clone should work faster
        
        columnIndexesTaken = Shuffle.shuffleIntArray(columnIndexesTaken);
        rowIndexesTaken = Shuffle.shuffleIntArray(rowIndexesTaken);
        
        // new array for result here
        @SuppressWarnings("unchecked")
        T[] res = (T[]) Array.newInstance(matrix[0].getClass().getComponentType(), matrix[0].length);
        
        // populating result
        for (int i = 0; i < matrix.length; i++) { 
            res[i] = matrix[rowIndexesTaken[i]][columnIndexesTaken[i]];
        }
        return res;
    }

    private void checkThatMatrixIsSquare(T[][] matrix) {
        for (T[] vec : matrix) {
            if (vec.length != matrix.length) {
                throw new IllegalArgumentException("The input matrix should be square.");
            }
        }
    }

    private int[] getIndexArray(int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = i;
        }
        return res;
    }
}
