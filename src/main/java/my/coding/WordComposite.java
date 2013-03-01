package my.coding;

import java.util.Arrays;
import java.util.Comparator;

public class WordComposite {

    public String findLongestComposite(String[] in) {
        if (in == null) {
            throw new NullPointerException("Input list cannot be null");
        }
        if (in.length == 0) {
            throw new IllegalArgumentException("Input list cannot be empty");
        }
        if (in.length == 1) {
            return in[0];
        }
        
        String[] sortedIn = Arrays.copyOf(in, in.length);
        Arrays.sort(sortedIn, new StringLengthComparator());
        
        for (int i = sortedIn.length - 1; i >= 0; i--) {
            if (isAWrodComposition(sortedIn, i, sortedIn[i])) {
                return sortedIn[i];
            }
        }
        return "";
    }

    private boolean isAWrodComposition(String[] sortedIn, int wordIndex, String word) {

        for (int i = wordIndex - 1; i >= 0; i--) {
            if (word.startsWith(sortedIn[i])) {
                if (word.equals(sortedIn[i]) || isAWrodComposition(sortedIn, wordIndex, word.substring(sortedIn[i].length()))) {
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
