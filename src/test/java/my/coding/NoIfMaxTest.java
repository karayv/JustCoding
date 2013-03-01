package my.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoIfMaxTest {

    @Test
    public void test() {
        double a = 10.0;
        double b = 10.2;
        
        double mid = (a + b) / 2;
        
        double max = Math.abs(a - mid) + mid;
        
        assertTrue(b == max);
    }

}
