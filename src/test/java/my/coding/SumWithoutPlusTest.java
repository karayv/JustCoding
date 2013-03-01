package my.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumWithoutPlusTest {

    SumWithoutPlus service = new SumWithoutPlus();

    @Test
    public void testSumZeros() {
        int sum = service.sum(0, 0);
        assertEquals("Zeros sum should be zero.", 0, sum);
    }

    @Test
    public void testSum5and6Integer() {
        int sum = service.sum(6, 5);
        assertEquals("Incorrect sum.", 11, sum);
    }

    @Test
    public void testSumPositiveInteger() {
        int sum = service.sum(186, 295);
        assertEquals("Incorrect sum.", 481, sum);
    }
    
    @Test
    public void testSumNegativeInteger() {
        int sum = service.sum(-5691, -67);
        assertEquals("Incorrect sum.", -5758, sum);
    }

    @Test
    public void testSumPositiveAndNegativeInteger() {
        int sum = service.sum(-6, 20);
        assertEquals("Incorrect sum.", 14, sum);
    }
    
    @Test
    public void testSumNegativeAndPositiveInteger() {
        int sum = service.sum(-26, 20);
        assertEquals("Incorrect sum.", -6, sum);
    }

    @Test
    public void testSum2Zeros() {
        int sum = service.sum2(0, 0);
        assertEquals("Zeros sum should be zero.", 0, sum);
    }

    @Test
    public void testSum25and6Integer() {
        int sum = service.sum2(6, 5);
        assertEquals("Incorrect sum.", 11, sum);
    }

    @Test
    public void testSum2PositiveInteger() {
        int sum = service.sum2(186, 295);
        assertEquals("Incorrect sum.", 481, sum);
    }
    
    @Test
    public void testSum2NegativeInteger() {
        int sum = service.sum2(-5691, -67);
        assertEquals("Incorrect sum.", -5758, sum);
    }

    @Test
    public void testSum2PositiveAndNegativeInteger() {
        int sum = service.sum2(-6, 20);
        assertEquals("Incorrect sum.", 14, sum);
    }
    
    @Test
    public void testSum2NegativeAndPositiveInteger() {
        int sum = service.sum2(-26, 20);
        assertEquals("Incorrect sum.", -6, sum);
    }

}
