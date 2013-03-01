package my.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnsortedLinkedListTest {

    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetOnEmptyList() {
        UnsortedLinkedList<String> list = new UnsortedLinkedList<String>();
        list.get(0);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void test() {
        UnsortedLinkedList<String> list = new UnsortedLinkedList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test2");
        list.add("Dupl");
        list.add("Test3");
        list.add("Dupl");
        list.add(null);
        list.add("Test4");
        list.add(null);
        
        list.removeDuplicates();
        
        assertEquals("Wrong element at 0.", "Test1", list.get(0));
        assertEquals("Wrong element at 1.", "Test2", list.get(1));
        assertEquals("Wrong element at 2.", "Dupl", list.get(2));
        assertEquals("Wrong element at 3.", "Test3", list.get(3));
        assertNull("Wrong element at 4.", list.get(4));
        assertEquals("Wrong element at 5.", "Test4", list.get(5));
        list.get(6);
    }

    
    @Test
    public void testGetItemByReversedIndex() {

        UnsortedLinkedList<String> list = new UnsortedLinkedList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        
        assertEquals("Wrong element.", "Test2", list.getByReversedIndex(2));
        
        
    }
    
}
