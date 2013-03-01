package my.coding;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceReplaceTest {

    SpaceReplace service = new SpaceReplace();
    
    @Test
    public void test() {
        String str = " Mr John Smith ";
        
        assertEquals("%20Mr%20John%20Smith%20", new String(service.replace(str.toCharArray())).trim());
    
    }
    
    // test for incorrect args here

}
