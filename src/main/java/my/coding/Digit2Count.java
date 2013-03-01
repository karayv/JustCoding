package my.coding;

public class Digit2Count {

    public int count2(int n) {
        
        int d, r = 0;
        
        int k1 = 1;
        int k2 = 10;
        
        if (n < 0) {
            n = ~n + 1;
        }
            
        int count = 0;
        
        do {
            int digit = n / k2;
            d = digit * k1;
            
            int remain = (n - d * 10 - 2 * k1 + 1);
            
            remain = remain < 0 ? 0 : remain;
            r = remain < k1 ? remain : k1;

            k1 = k1 * 10;
            k2 = k2 * 10;
            
            count += d + r;
        } while (d != 0 || r != 0);
        return count;
    }

}
