package my.coding;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FindTextIndexesTest {

    @Test(expected=NullPointerException.class)
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
        assertArrayEquals(new Integer[] {0, 10}, indexes.toArray());
    }

}
