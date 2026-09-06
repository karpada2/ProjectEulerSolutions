import jdk.jshell.execution.Util;

public final class P070 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P070().run());
    }

    public static int UPPER_BOUND = 10_000_001;

    public static boolean isSmaller(long numerator1, long denominator1, long numerator2, long denominator2) {
        return numerator1*denominator2 < numerator2*denominator1;
    }

    @Override
    public String run() {
        UtilLibrary.totient(UPPER_BOUND, true);
        int minN = 2;
        int minTotient = UtilLibrary.totient(minN, true);
        for (int i = 3; i < UPPER_BOUND; i++) {
            int totient = UtilLibrary.totient(i, true);
            if (isSmaller(i, totient, minN, minTotient) && UtilLibrary.isPermutationOf(i, totient)) {
                minN = i;
                minTotient = totient;
            }
        }

        return Integer.toString(minN);
    }
}
