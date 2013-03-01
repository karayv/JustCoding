package my.coding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Digit2CountTest {

    Digit2Count service = new Digit2Count();
    
    @Test
    public void testCount2With24() {
        assertEquals(8, service.count2(24));
    }
    
    @Test
    public void testCount2With224() {
        assertEquals(73, service.count2(224));
    }
    
    @Test
    public void testCount2With1() {
        assertEquals(0, service.count2(1));
    }

    @Test
    public void testCount2WithM24() {
        assertEquals(8, service.count2(-24));
    }

    @Test
    public void testCount2WithM224() {
        assertEquals(73, service.count2(-224));
    }


}
