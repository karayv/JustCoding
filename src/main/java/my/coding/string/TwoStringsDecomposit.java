package my.coding.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Task.
 * 
 * Write an algorithm to verify whether two strings are decomposition of each
 * other.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class TwoStringsDecomposit {

    /**
     * Checks whether two string strings have same set of symbols.
     * 
     * @param string1
     * @param string2
     * @return true if two strings are decomposition of each other.
     */
    public boolean sameSetOfSymbols(String string1, String string2) {
        if (string1 == null || string2 ==null) throw new NullPointerException("Null.");
        if ("".equals(string1) || "".equals(string2)) throw new IllegalArgumentException("Empty.");

        if (string1.length() != string2.length()) {
            return false;
        }

        Map<Character, Integer> str1SybolsMap = symbolsMap(string1);
        Map<Character, Integer> str2SybolsMap = symbolsMap(string2);
        
        return compareSymbolsMap(str1SybolsMap, str2SybolsMap);
    }

    private boolean compareSymbolsMap(Map<Character, Integer> str1SybolsMap, Map<Character, Integer> str2SybolsMap) {

        if (str1SybolsMap.size() != str2SybolsMap.size()) {
            return false;
        }
        for (Character key : str1SybolsMap.keySet()) {
            Integer num1 = str1SybolsMap.get(key);
            Integer num2 = str2SybolsMap.get(key);
            if (num2 == null || !num2.equals(num1)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> symbolsMap(String string) {
        Map<Character, Integer> res = new HashMap<>(string.length());
        for (int i = 0; i < string.length(); i++) {
            Integer num = res.get(string.charAt(i));
            if (num == null) {
                res.put(string.charAt(i), 1);
            } else {
                num++;
                res.put(string.charAt(i), num);
            }
        }
        return res;
    }

}
