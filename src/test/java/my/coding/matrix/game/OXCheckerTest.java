package my.coding.matrix.game;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Test for the helper service for tick-tack-toe game field with arbitrary
 * field size and arbitrary size of the line to win.
 * 
 * @author Andrey Karayvansky
 *
 */
public class OXCheckerTest {

    OXChecker service = new OXChecker();
    
    @Test(expected=NullPointerException.class)
    public void testNullArgs() {
        
        byte[][] field = null;
        
        int lastX = 0;
        
        int lastY = 0; 
        
        service.check(field, lastX, lastY, 1);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testOutOfBoundXYArgs() {
        
        byte[][] field = {{}};
        
        int lastX = 1;
        
        int lastY = 1; 
        
        service.check(field, lastX, lastY, 1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeOrZeroArgs() {
        byte[][] field = {{}};
        
        service.check(field, 0, -1, -2);
    }

    @Test
    public void test5CellsWon() {
        
        byte[][] field = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 1, 2, 0},
                {0, 1, 0, 2, 0, 2, 1, 0},
                {0, 0, 1, 2, 0, 0, 0, 0},
                {0, 2, 1, 1, 1, 2, 2, 0},
                {0, 0, 0, 2, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 2, 0}};
        
        int lastX = 4;
        
        int lastY = 3; 
        
        int sizeToWin = 5;
        
        boolean won = service.check(field, lastX, lastY, sizeToWin);
        
        assertTrue("Should win.", won);
    }

    @Test
    public void test4CellsNotWon() {
        
        byte[][] field = {
                {0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 2, 0},
                {0, 1, 2, 2, 0, 0},
                {0, 0, 2, 2, 0, 0},
                {0, 1, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0}};
        
        int lastX = 2;
        
        int lastY = 3; 
        
        int sizeToWin = 4;
        
        boolean won = service.check(field, lastX, lastY, sizeToWin);
        
        assertFalse("Should not win.", won);
    }

}
