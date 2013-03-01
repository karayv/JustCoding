package my.coding.shuffle;

/**
 * The solution for classical task about card shuffling. It is based on simple shuffling algorithm.
 * 
 * @author Andrey Karayvansky
 *
 */
public class CardShuffle {

    /**
     * Shuffles the card codes array (every card is a unique code in the array).
     * 
     * @param cardCodes card codes array
     * @return shuffled input array
     */
    public int[] shuffle(int[] cardCodes) {
        if (cardCodes == null) {
            throw new NullPointerException("Card codes array cannot be null.");
        }
        if (cardCodes.length == 0 || cardCodes.length == 1) {
            return cardCodes;
        }
        
        return Shuffle.shuffleIntArray(cardCodes);
    }
}
