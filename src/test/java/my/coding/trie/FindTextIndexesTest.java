package my.coding.trie;

import static org.junit.Assert.*;

import java.util.List;

import my.coding.trie.FindTextIndexes;

import org.junit.Test;

/**
 * Test for task. 
 * 
 * Given a string s and an array of smaller strings T, design a
 * method to search s for each small string in T.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class FindTextIndexesTest {

    @Test(expected = NullPointerException.class)
    public void testNullArg() {
        new FindTextIndexes(null);
    }

    @Test
    public void testEmptyStringArg() {
        FindTextIndexes text = new FindTextIndexes("");
        List<Integer> indexes = text.find("as");
        assertArrayEquals(new Integer[] {}, indexes.toArray());
    }

    @Test
    public void test() {
        FindTextIndexes text = new FindTextIndexes("asd fghjk asf");
        List<Integer> indexes = text.find("as");
        assertArrayEquals(new Integer[] { 0, 10 }, indexes.toArray());
    }

}
