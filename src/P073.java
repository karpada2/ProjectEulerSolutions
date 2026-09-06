import java.util.HashSet;

public final class P073 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P073().run());
    }

    public static int UPPER_LIMIT = 12_000;
    public static UtilLibrary.Fraction half = new UtilLibrary.Fraction(1, 2);
    public static UtilLibrary.Fraction third = new UtilLibrary.Fraction(1, 3);

    @Override
    public String run() {
        long count = 0;
        for (int denominator = 2; denominator <= UPPER_LIMIT; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (UtilLibrary.gcd(numerator, denominator) == 1) {
                    if (new UtilLibrary.Fraction(numerator, denominator).compareTo(half) < 0 && new UtilLibrary.Fraction(numerator, denominator).compareTo(third) > 0) {
                        count++;
                    }
                }
            }
        }

        return Long.toString(count);
    }
}