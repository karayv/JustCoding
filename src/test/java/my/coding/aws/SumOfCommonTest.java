package my.coding.aws;

import static org.junit.Assert.*;

import java.math.BigInteger;


import org.junit.Test;

public class SumOfCommonTest {

    
    SumOfCommon service = new SumOfCommon();
    
    @Test(expected=NullPointerException.class)
    public void testNullArg() {
        service.getSummOfCommon(null);
    }
    
    @Test
    public void testEmptyArrayArg() {
        BigInteger sum = service.getSummOfCommon(new int[]{});
        assertEquals("The result of empty array should be null.", BigInteger.ZERO, sum);
    }

    @Test
    public void testFirstExampleArray() {
        int[] array = new int[] {2, 4, 5, 6, 4};
        BigInteger sum = service.getSummOfCommon(array);
        assertEquals("Incorrect sum.", new BigInteger("" + 8), sum);
    }

    @Test
    public void testSecondExampleArray() {
        int[] array = new int[] {1, 2, 1, 3, 1};
        BigInteger sum = service.getSummOfCommon(array);
        assertEquals("Incorrect sum.", new BigInteger("" + 3), sum);
    }

    @Test
    public void testOneElemArray() {
        int[] array = new int[] {7};
        BigInteger sum = service.getSummOfCommon(array);
        assertEquals("Incorrect sum.", new BigInteger("" + 7), sum);
    }

    @Test
    public void testTwoCommonElemArray() {
        int[] array = new int[] {7, 7, 7, 7, 9, 9, 9, 9};
        BigInteger sum = service.getSummOfCommon(array);
        assertEquals("Incorrect sum.", new BigInteger("" + 28), sum);
    }

}
