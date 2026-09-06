import java.util.Arrays;

public final class P069 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P069().run());
    }

    public static int UPPER_BOUND = 1_000_001;
    public static boolean[] primality = UtilLibrary.listPrimality(UPPER_BOUND);

    public static boolean isBigger(int numerator1, int denominator1, int numerator2, int denominator2) {
        return (long)(numerator1)*denominator2 > (long)(numerator2)*denominator1;
    }

    @Override
    public String run() {
        int maxN = 2;
        int maxTotient = UtilLibrary.totient(maxN);
        for (int i = 3; i < UPPER_BOUND; i++) {
            int totient = UtilLibrary.totient(i);
            if (isBigger(i, totient, maxN, maxTotient)) {
                maxN = i;
                maxTotient = totient;
            }
        }

        return Integer.toString(maxN);
    }
}
