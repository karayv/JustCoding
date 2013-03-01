package my.coding.numbers;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the very basic way to find max value without if statement.
 * 
 * @author Andrey Karayvansky
 *
 */
public class NoIfMaxTest {

    @Test
    public void test() {
        double a = 10.0;
        double b = 10.2;
        
        double mid = (a + b) / 2;
        
        //TODO this is a mistake abs contains conditions inside.
        double max = Math.abs(a - mid) + mid;
        
        assertTrue(b == max);
    }

}
