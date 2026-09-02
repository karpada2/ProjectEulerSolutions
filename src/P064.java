import java.util.ArrayList;
import java.util.HashSet;

public final class P064 implements Solution {

    public static void main(String[] args) {
        System.out.println(new P064().run());
    }

    public static int UPPER_BOUND = 10_000;
    public static UtilLibrary.Fraction baseFraction = new UtilLibrary.Fraction(1, 1);

    public static int getFirstTerm(int n) {
        for (int i = 2; i*i <= UPPER_BOUND; i++) {
            if (i*i > n) {
                return i-1;
            }
        }
        return -1;
    }

    public static long getNextAdded(long added, long divisor, int number) {
        int nextTerm = (int)Math.floor((Math.sqrt(number) + added)/divisor);
        return Math.abs(added - (divisor*nextTerm));
    }

    @Override
    public String run() {
        int counter = 0;
        HashSet<Integer> perfectSquares = new HashSet<>((int)(Math.sqrt(UPPER_BOUND))+1);
        for (int i = 1; i < (int)(Math.sqrt(UPPER_BOUND))+1; i++) {
            perfectSquares.add(i*i);
        }

        for (int i = 2; i <= UPPER_BOUND; i++) {
            if (!perfectSquares.contains(i)) {
                int length = 1;
                long added = getFirstTerm(i);
                UtilLibrary.Fraction currentFraction = new UtilLibrary.Fraction(1, i - (long) getFirstTerm(i)*getFirstTerm(i));
                while (!currentFraction.equals(baseFraction)) {
                    added = getNextAdded(added, currentFraction.denominator.longValueExact(), i);
                    currentFraction = new UtilLibrary.Fraction(currentFraction.denominator.longValueExact(), i - added*added).simplified();
                    length++;
                }
                if (length%2 == 1) {
                    counter++;
                }
            }
        }

        return Integer.toString(counter);
    }
}
