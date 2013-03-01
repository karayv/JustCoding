package my.coding.matrix;

import static org.junit.Assert.*;

import my.coding.matrix.ZeroCrosses;

import org.junit.Test;

/**
 * Test for task.
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 * 
 * @author Andrey Karayvansky
 *
 */
public class ZeroCrossesTest {

    ZeroCrosses service = new ZeroCrosses();
    
    @Test(expected=NullPointerException.class)
    public void testArgNull() {
        int[][] inp = null;
        
        service.drawZeroCrosses(inp);
    }
    
    @Test
    public void testDrawZeroCrosses() {
        int[][] inp = {{0, 1,  0, 2},
                      {-2, 3, 10, 8},
                      { 0, 2,-20, 6},
                      { 1, 2,  4,-3},
                      { 7, 3,  5, 0}};
        
        int[][] out = service.drawZeroCrosses(inp);
        
        int[][] expct = {{0, 0,  0, 0},
                        { 0, 3,  0, 0},
                        { 0, 0,  0, 0},
                        { 0, 2,  0, 0},
                        { 0, 0,  0, 0}};
        
        assertArrayEquals(expct,  out);
    }

}
