package my.coding.string;

import static org.junit.Assert.*;

import my.coding.string.SpaceReplace;

import org.junit.Test;

/**
 * Test for task.
 * 
 * Write a method to replace all spaces in a string with ‘%20’.
 * 
 * @author Andrey Karayvansky
 *
 */
public class SpaceReplaceTest {

    SpaceReplace service = new SpaceReplace();
    
    @Test
    public void test() {
        String str = " Mr John Smith ";
        
        assertEquals("%20Mr%20John%20Smith%20", new String(service.replace(str.toCharArray())).trim());
    
    }
    
    @Test
    public void testSpacesOnly() {
        String str = "    ";
        
        assertEquals("%20%20%20%20", new String(service.replace(str.toCharArray())).trim());
    }

    @Test(expected=NullPointerException.class)
    public void testNullArg() {
        service.replace(null);
    }
}
