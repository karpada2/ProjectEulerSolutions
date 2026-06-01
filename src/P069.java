import java.util.Arrays;

public final class P069 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P069().run());
    }

    public static int UPPER_BOUND = 1_000_001;
    public static boolean[] primality = UtilLibrary.listPrimality(UPPER_BOUND);

    public static int totient(int n) {
        if (n <= 0) {
            return -1;
        }
        if (primality[n]) {
            return n-1;
        }

        int[] factors = UtilLibrary.getPrimeFactors(n);
        int result = 1;
        for (int i = 0; i < factors.length; i++) {
            int power = 1;
            int currFactor = factors[i];
            while (i + 1 < factors.length && factors[i+1] == currFactor) {
                i++;
                power *= currFactor;
            }
            result *= power * (currFactor - 1);
        }

        return result;
    }

    public static boolean isBigger(int numerator1, int denominator1, int numerator2, int denominator2) {
        return (long)(numerator1)*denominator2 > (long)(numerator2)*denominator1;
    }

    @Override
    public String run() {
        int maxN = 2;
        int maxTotient = totient(maxN);
        for (int i = 3; i < UPPER_BOUND; i++) {
            int totient = totient(i);
            if (isBigger(i, totient, maxN, maxTotient)) {
                maxN = i;
                maxTotient = totient;
            }
        }

        return Integer.toString(maxN);
    }
}
