package my.coding;

public class StringUniqueSybols {

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