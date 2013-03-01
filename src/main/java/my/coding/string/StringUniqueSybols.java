package my.coding.string;

/**
 * Task.
 * 
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * 
 * @author Andrey Karayvansky
 * 
 */
public class StringUniqueSybols {

    /**
     * Checks whether the string contains only unique characters.
     * 
     * @param str the string to check
     * @return true the input string contains only unique characters
     */
    public boolean uniqueOnly(String str) {
        if (str == null)
            throw new NullPointerException("The argument should not be null.");
        if ("".equals(str))
            throw new IllegalArgumentException("The string should not be empty.");

        for (int i = 0; i < str.length(); i++) {
            if (!uniqueSymbol(str, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean uniqueSymbol(String str, int pos) {
        char symbol = str.charAt(pos);
        for (int i = 0; i < str.length(); i++) {
            if (i != pos && symbol == str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}