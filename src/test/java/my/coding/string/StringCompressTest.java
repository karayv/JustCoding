package my.coding.string;

import static org.junit.Assert.*;

import my.coding.string.StringCompress;

import org.junit.Test;

/**
 * Test for task.
 * 
 * Write algorithm to compress a string in the like aaaabbbccce -> a4b3c3e1. If
 * compression is not effective, return initial string.
 * 
 * @author Andrey Karayvansky
 *
 */
public class StringCompressTest {

    StringCompress service = new StringCompress();
    
    @Test
    public void testCompress() {
        assertEquals("a2b1c5a3", service.compress("aabcccccaaa"));
    }

    @Test
    public void testCompressIsUnefficient() {
        assertEquals("abcccaa", service.compress("abcccaa"));
    }

    @Test
    public void testArgNull() {
        assertNull(service.compress(null));
    }

    @Test
    public void testArgEmpty() {
        assertEquals("", service.compress(""));
    }

}
