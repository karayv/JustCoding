package my.coding.aws;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * Given square matrix of N rows and N columns return array of N elements as
 * output, choosing them at random one from each row and one from each column.
 * Original matrix does not need to be preserved if it helps the solution.
 * 
 * @author Andrey Karayvansky
 *
 */
public class RandomVectorFromMatrixTest {
    
    @Test(expected=NullPointerException.class)
    public void testNullArg() {
        RandomVectorFromMatrix<Object> service = new RandomVectorFromMatrix<>();
        service.getVector(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNonSquareMatrixArg() {
        RandomVectorFromMatrix<String> service = new RandomVectorFromMatrix<>();
        String[][] nonSquareMatr = new String[][] {
                                        {"a", "b", "c"}
                                    };
        service.getVector(nonSquareMatr);
    }


    @Test
    public void testAlgorithm() {
        RandomVectorFromMatrix<String> service = new RandomVectorFromMatrix<>();
        String[][] nonSquareMatr = new String[][] {
                                        {"a1", "b1", "c1", "d1", "e1"},
                                        {"a2", "b2", "c2", "d2", "e2"},
                                        {"a3", "b3", "c3", "d3", "e3"},
                                        {"a4", "b4", "c4", "d4", "e4"},
                                        {"a5", "b5", "c5", "d5", "e5"}
                                    };
        String[] result = service.getVector(nonSquareMatr);
        
        assertEquals("Wrong resulting vector size.", 5, result.length);
        
        Set<Character> chars = new HashSet<>(); 
        for (String item : result) {
            chars.add(item.charAt(0));
        }
        for (char c = 'a'; c <= 'e'; c++) {
            assertTrue("Not all the rows in the vector.", chars.contains(c));
        }
        chars.clear(); 
        for (String item : result) {
            chars.add(item.charAt(1));
        }
        for (char c = '1'; c <= '5'; c++) {
            assertTrue("Not all the columns in the vector.", chars.contains(c));
        }
    }

}
