package my.coding.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Task.
 * 
 * Write an algorithm to find a longest word - composition of other words in an
 * array of words.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class WordComposite {

    /**
     * Finds the longest word - composition of other words in the input string array.
     * 
     * @param in the array of words
     * @return the longest word - composition
     */
    public String findLongestComposite(String[] in) {
        if (in == null) {
            throw new NullPointerException("Input array cannot be null");
        }
        if (in.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty");
        }
        if (in.length == 1) {
            return in[0];
        }
        
        String[] sortedIn = Arrays.copyOf(in, in.length);
        Arrays.sort(sortedIn, new StringLengthComparator());
        
        for (int i = sortedIn.length - 1; i >= 0; i--) {
            if (isAWordComposition(sortedIn, i, sortedIn[i])) {
                return sortedIn[i];
            }
        }
        return "";
    }

    private boolean isAWordComposition(String[] sortedIn, int wordIndex, String word) {

        for (int i = wordIndex - 1; i >= 0; i--) {
            if (word.startsWith(sortedIn[i])) {
                if (word.equals(sortedIn[i]) || isAWordComposition(sortedIn, wordIndex, word.substring(sortedIn[i].length()))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null)
                return -1;
            if (o2 == null || o1.length() > o2.length())
                return 1;
            if (o2.length() > o1.length())
                return -1;
            return 0;
        }
        
    }
}
