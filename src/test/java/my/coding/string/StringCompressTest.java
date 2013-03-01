package my.coding.string;

import static org.junit.Assert.*;

import my.coding.string.StringCompress;

import org.junit.Test;

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
