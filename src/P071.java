public final class P071 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P071().run());
    }

    public static int UPPER_LIMIT = 1_000_000;
    public static int wantedNumerator = 3;
    public static int wantedDenominator = 7;

    public static boolean isSmaller(long numerator1, long denominator1, long numerator2, long denominator2) {
        return numerator1*denominator2 < numerator2*denominator1;
    }
    public static boolean isBigger(long numerator1, long denominator1, long numerator2, long denominator2) {
        return numerator1*denominator2 > numerator2*denominator1;
    }

    @Override
    public String run() {
        for (long denominator = UPPER_LIMIT; denominator >= 2; denominator--) {
            for (long numerator = denominator - 1; numerator >= 1; numerator--) {
                if (isSmaller(numerator, denominator, wantedNumerator, wantedDenominator)) {
                    long gcd = UtilLibrary.gcd(numerator, denominator);
                    if ((wantedNumerator*(denominator/gcd)) - (numerator*(wantedDenominator/gcd)) == 1) {
                        return Long.toString(numerator / UtilLibrary.gcd(numerator, denominator));
                    }
                }
            }
        }
        return "-1";
    }
}
