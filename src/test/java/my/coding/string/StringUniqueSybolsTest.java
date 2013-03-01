package my.coding.string;

import static org.junit.Assert.*;

import my.coding.string.StringUniqueSybols;

import org.junit.Test;

public class StringUniqueSybolsTest {

    StringUniqueSybols service = new StringUniqueSybols();
    
    @Test
    public void testContainsNonUnique() {
        assertFalse(service.uniqueOnly("asdfghjf"));
    }

    @Test
    public void testContainsUniqueOnly() {
        assertTrue(service.uniqueOnly("asdfghjkl"));
    }

    @Test(expected=NullPointerException.class)
    public void testIfInputNull() {
        assertTrue(service.uniqueOnly(null));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIfInputEmpty() {
        assertTrue(service.uniqueOnly(""));
    }

}
