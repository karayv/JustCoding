package my.coding.shuffle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import my.coding.shuffle.CardShuffle;

import org.junit.Test;

/**
 * Test class for classical task about card shuffling.
 * 
 * @author Andrey Karayvansky
 *
 */
public class CardShuffleTest {

    CardShuffle service = new CardShuffle();
    
    @Test(expected=NullPointerException.class)
    public void testNullArgs() {
        service.shuffle(null);
    }

    @Test
    public void testEmptyArrayArgs() {
        assertArrayEquals(new int[]{}, service.shuffle(new int[]{}));
    }

    @Test
    public void testShuffle() {
        int[] cardCodes = new int[36];
        int[] copyCardCodes = new int[36];
        
        for (int i = 1; i<= cardCodes.length; i++) {
            cardCodes[i - 1] = i;
            copyCardCodes[i - 1] = i;
        }
        
        int[] shuffledCards = service.shuffle(cardCodes);
        
        assertFalse("Cards were not shuffled", Arrays.equals(copyCardCodes, shuffledCards));

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < cardCodes.length; i++) {
            set1.add(copyCardCodes[i]);
            set2.add(shuffledCards[i]);
        }
        
        assertEquals(set1, set2);
    }

}
