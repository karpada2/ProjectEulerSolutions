import java.math.BigInteger;

public final class P053 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P053().run());
    }

    public static int MAX_VALUE = 1_000_000;
    public static BigInteger MAX_VALUE_BIG_INTEGER = BigInteger.valueOf(MAX_VALUE);

    public static int amountOfChoosesBiggerThan(int n) {
        int r;
        boolean foundFlag = false;
        for (r = 0; r < (n/2)+1; r++) {
            if (UtilLibrary.choose(n, r).compareTo(MAX_VALUE_BIG_INTEGER) > 0) {
                foundFlag = true;
                break;
            }
        }
        if (foundFlag) {
            return (n - (2*r))+1;
        }
        return 0;
    }

    @Override
    public String run() {
        int sum = 0;
        for (int n = 23; n <= 100; n++) {
            sum += amountOfChoosesBiggerThan(n);
        }
        return Integer.toString(sum);
    }
}
