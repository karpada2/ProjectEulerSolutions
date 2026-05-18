import java.math.BigInteger;

public final class P055 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P055().run());
    }

    static long currentNumber = 0;
    
    public static boolean doesBecomePalindrome(BigInteger number, int depthAllowed) {
        if (depthAllowed == 0) {
            return false;
        }
        number = number.add(new BigInteger(UtilLibrary.reverse(number.toString())));
        if (UtilLibrary.isPalindrome(number.toString())) {
            return true;
        }
        
        return doesBecomePalindrome(number, depthAllowed-1);
    }

    @Override
    public String run() {
        int count = 0;
        for (int i = 1; i < 10_000; i++) {
            currentNumber = i;
            count += doesBecomePalindrome(BigInteger.valueOf(i), 50) ? 0 : 1;
        }
        return Integer.toString(count);
    }
}
