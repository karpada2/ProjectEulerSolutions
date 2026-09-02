import java.math.BigInteger;
import java.util.Arrays;

public final class P065 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P065().run());
    }

    public static int sumDigits(long number) {
        int sum = 0;
        int digitCount = UtilLibrary.countDigits(number);
        for (int i = 0; i < digitCount; i++) {
            sum += (int)(number%10);
            number /= 10;
        }
        return sum;
    }

    @Override
    public String run() {
        int[] terms = new int[100];
        terms[0] = 2;
        for (int i = 0; (3*i) + 3 < terms.length; i++) {
            terms[(3*i)+1] = 1;
            terms[(3*i)+2] = 2*(i+1);
            terms[(3*i)+3] = 1;
        }

        UtilLibrary.Fraction fraction = new UtilLibrary.Fraction(1, terms[terms.length-1]);
        for (int i = terms.length-2; i >= 0; i--) {
            fraction = fraction.add(terms[i]).inverse();
        }
        fraction = fraction.inverse();

        return Long.toString(UtilLibrary.sumDigits(fraction.numerator));
    }
}
