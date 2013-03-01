package my.coding;

import static org.junit.Assert.*;

import org.junit.Test;

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
                      { 1, 2,  4, 0},
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
