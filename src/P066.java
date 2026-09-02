import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

public final class P066 implements Solution {

    public static void main(String[] args) {
        System.out.println(new P066().run());
    }

    public static int getFirstTerm(int n) {
        for (int i = 2; i*i <= UPPER_BOUND; i++) {
            if (i*i > n) {
                return i-1;
            }
        }
        return -1;
    }

    public static BigInteger getNextTerm(BigInteger added, BigInteger divisor, int number) {
        return (BigInteger.valueOf((long)Math.floor(Math.sqrt(number))).add(added)).divide(divisor);
    }

    public static BigInteger getNextAdded(BigInteger added, BigInteger divisor, int number) {
        BigInteger nextTerm = getNextTerm(added, divisor, number);
        return added.subtract(divisor.multiply(nextTerm)).abs();
    }

    public static UtilLibrary.Fraction getNeededConvergent(int D) {
        UtilLibrary.Fraction baseFraction = new UtilLibrary.Fraction(1, 1);
        int length = 1;
        BigInteger added = BigInteger.valueOf(getFirstTerm(D));
        UtilLibrary.Fraction currentFraction = new UtilLibrary.Fraction(1, D - (long) getFirstTerm(D)*getFirstTerm(D));
        while (!currentFraction.equals(baseFraction)) {
            added = getNextAdded(added, currentFraction.denominator, D);
            currentFraction = new UtilLibrary.Fraction(currentFraction.denominator, BigInteger.valueOf(D).subtract(added.multiply(added))).simplified();
            length++;
        }
        int neededConvergentIndex = 0;
        if (length%2 == 0) {
            neededConvergentIndex = length;
        }
        else {
            neededConvergentIndex = 2*length;
        }

        BigInteger[] terms = new BigInteger[neededConvergentIndex];
        terms[0] = BigInteger.valueOf(getFirstTerm(D));
        added = BigInteger.valueOf(getFirstTerm(D));
        currentFraction = new UtilLibrary.Fraction(1, D - (long) getFirstTerm(D)*getFirstTerm(D));
        for (int i = 1; i < terms.length; i++) {
            terms[i] = getNextTerm(added, currentFraction.denominator, D);
            added = getNextAdded(added, currentFraction.denominator, D);
            currentFraction = new UtilLibrary.Fraction(currentFraction.denominator, BigInteger.valueOf(D).subtract(added.multiply(added))).simplified();
        }

        UtilLibrary.Fraction fraction = new UtilLibrary.Fraction(BigInteger.ONE, terms[terms.length-1]);
        for (int i = terms.length-2; i >= 0; i--) {
            fraction = fraction.add(terms[i]).inverse();
        }
        fraction = fraction.inverse();
        return fraction;
    }

    public static BigInteger getMinimalSolution(int D) {
        return getNeededConvergent(D).numerator;
    }

    public static int UPPER_BOUND = 1000;

    @Override
    public String run() {
        BigInteger maxXValue = BigInteger.valueOf(-1);
        BigInteger maxDValue = BigInteger.valueOf(-1);
        HashSet<Integer> perfectSquares = new HashSet<>((int)(Math.sqrt(UPPER_BOUND))+1);
        for (int i = 1; i < (int)(Math.sqrt(UPPER_BOUND))+1; i++) {
            perfectSquares.add(i*i);
        }

        for (int D = 2; D <= UPPER_BOUND; D++) {
            if (!perfectSquares.contains(D)) {
                BigInteger solution = getMinimalSolution(D);
                if (solution.compareTo(maxXValue) > 0) {
                    maxXValue = solution;
                    maxDValue = BigInteger.valueOf(D);
                }
            }
        }

        return maxDValue.toString();
    }
}
