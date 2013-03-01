package my.coding;

public class CardShuffle {

    public int[] shuffle(int[] cardCodes) {
        if (cardCodes == null) {
            throw new NullPointerException("Card codes array cannot be null.");
        }
        if (cardCodes.length == 0 || cardCodes.length == 1) {
            return cardCodes;
        }
        
        for (int i = 0; i < cardCodes.length - 1; i++) {
            int rndCard = (int)(Math.random() * cardCodes.length - i) + i;
            swapCards(cardCodes, i, rndCard);
        }
        return cardCodes;
    }

    private void swapCards(int[] cardCodes, int i, int rndCard) {
        int temp = cardCodes[i];
        cardCodes[i] = cardCodes[rndCard];
        cardCodes[rndCard] = temp;
    }

}
