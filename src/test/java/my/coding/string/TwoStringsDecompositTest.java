package my.coding.string;

import static org.junit.Assert.*;

import my.coding.string.TwoStringsDecomposit;

import org.junit.Test;

/**
 * Test for the task.
 * 
 * Write an algorithm to verify whether two strings are decomposition of each
 * other.
 * 
 * @author Andrey Karayvansky
 *
 */
public class TwoStringsDecompositTest {

    TwoStringsDecomposit service = new TwoStringsDecomposit();
    
    @Test
    public void testDifferentSize() {
        assertFalse(service.sameSetOfSymbols("asdf", "gfdsa"));
    }

    @Test
    public void testSameSizeDiffSymbols() {
        assertFalse(service.sameSetOfSymbols("asdfa", "fdsaf"));
    }

    @Test
    public void testSameSetOfSymbols() {
        assertTrue(service.sameSetOfSymbols("asdfa", "fdsaa"));
    }

    @Test(expected=NullPointerException.class)
    public void testArg1Null() {
        service.sameSetOfSymbols(null, "fdsaa");
    }

    @Test(expected=NullPointerException.class)
    public void testArg2Null() {
        service.sameSetOfSymbols("asdfa", null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testArg1Empty() {
        service.sameSetOfSymbols("", "fdsaa");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testArg2Empty() {
        service.sameSetOfSymbols("asdfa", "");
    }

}
