import java.util.HashSet;

public final class P072 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P072().run());
    }

    public static int UPPER_LIMIT = 1_000_000;

    @Override
    public String run() {
        long count = 0;
        for (int denominator = 2; denominator <= UPPER_LIMIT; denominator++) {
            System.out.println((double)denominator/UPPER_LIMIT);
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (UtilLibrary.gcd(numerator, denominator) == 1) {
                    count++;
                }
            }
        }

        return Long.toString(count);
    }
}
