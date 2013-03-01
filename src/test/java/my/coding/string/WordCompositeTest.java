package my.coding.string;

import static org.junit.Assert.*;

import my.coding.string.WordComposite;

import org.junit.Test;

public class WordCompositeTest {

    WordComposite service = new WordComposite();

    @Test(expected=NullPointerException.class)
    public void testNullArg() {
        String[] in = null;
        service.findLongestComposite(in);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testEmptyArrayArg() {
        String[] in = new String[0];
        service.findLongestComposite(in);
    }

    @Test
    public void testOneElemArrayArg() {
        String[] in = new String[]{"theword"};
        String res = service.findLongestComposite(in);
        assertEquals("theword", res);
    }

    @Test
    public void test() {
        String[] in = new String[] {"abc", "abcdegf",  "degf", "deg", "degfabcasd", "degfabcopqr", "opqr"};
        
        String res = service.findLongestComposite(in);

        assertEquals("degfabcopqr", res);
    }

}
