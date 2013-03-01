package my.coding;

public class SpaceReplace {

    public char[] replace(char[] charArray) {
        // do checks for input here
        
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
