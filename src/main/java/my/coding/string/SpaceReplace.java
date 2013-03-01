package my.coding.string;

/**
 * Task.
 * 
 * Write a method to replace all spaces in a string with ‘%20’.
 * 
 * @author Andrey Karayvansky
 *
 */
public class SpaceReplace {

    /**
     * Replace all spaces in char array with ‘%20’.
     * 
     * @param charArray
     * @return resulting char array
     */
    public char[] replace(char[] charArray) {
        // assume that we have enough length
        char[] res = new char[charArray.length << 2];
        char[] space = new char[] {'%', '2','0'};
        
        int index = 0;
        int resPos = 0;
        
        while (index < charArray.length) {
            int newIndex = findNextSpaceIndex(charArray, index);
            if (newIndex > index) {
                int length = newIndex - index;
                System.arraycopy(charArray, index, res, resPos, length);
                resPos += length;
                
            }
            index = newIndex + 1;
            if (newIndex < charArray.length) {
                System.arraycopy(space, 0, res, resPos, 3);
                resPos += 3;
            }
        }
        
        return res;
    }

    private int findNextSpaceIndex(char[] charArray, int index) {
        for (int i = index; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                return i;
            }
        }
        return charArray.length;
    }

}
