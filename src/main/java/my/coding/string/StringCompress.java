package my.coding.string;

/**
 * Task.
 * 
 * Write algorithm to compress a string in the like aaaabbbccce -> a4b3c3e1. If
 * compression is not effective, return initial string.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class StringCompress {

    /**
     * Compresses a string. Return initial string if compression is not
     * effective.
     * 
     * @param string
     * @return
     */
    public String compress(String string) {
        if (string == null || "".equals(string)) {
            return string;
        }
        
        StringBuilder sb  = new StringBuilder();

        int count = 1;
        char c = string.charAt(0);
        sb.append(c);
        
        for (int i = 1; i < string.length(); i++) {
            char curr = string.charAt(i);

            if (c == curr) {
                count++;
            } else {
                sb.append(count).append(curr);
                c = curr;
                count = 1;
            }
        }
        
        sb.append(count);

        String compressed = sb.toString();
        return compressed.length() > string.length() ? string : compressed;
    }

}
