import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

public final class P066 implements Solution {
    public static class Fraction {
        BigInteger numerator;
        BigInteger denominator;

        public Fraction(long numerator, long denominator) {
            this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
        }
        public Fraction(BigInteger numerator, BigInteger denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction times(Fraction other) {
            return this.times(other.numerator, other.denominator);
        }
        public Fraction times(BigInteger numerator, BigInteger denominator) {
            return new Fraction(this.numerator.multiply(numerator), this.denominator.multiply(denominator));
        }

        public Fraction inverse() {
            return new Fraction(denominator, numerator);
        }

        public Fraction divide(long numerator, long denominator) {
            return divide(new Fraction(numerator, denominator));
        }
        public Fraction divide(Fraction other) {
            return this.times(other.inverse());
        }

        public Fraction add(long number) {
            return add(BigInteger.valueOf(number));
        }
        public Fraction add(BigInteger number) {
            return add(number.multiply(this.denominator), this.denominator);
        }
        public Fraction add(BigInteger numerator, BigInteger denominator) {
            if (this.denominator.equals(denominator)) {
                return new Fraction(this.numerator.add(numerator), denominator);
            }
            return new Fraction(this.numerator.multiply(denominator).add(numerator.multiply(this.denominator)), this.denominator.multiply(denominator));
        }
        public Fraction add(Fraction other) {
            return add(other.numerator, other.denominator);
        }

        public Fraction simplified() {
            boolean shouldBeNegative = (this.numerator.compareTo(BigInteger.ZERO) < 0) ^ (this.denominator.compareTo(BigInteger.ZERO) < 0);
            BigInteger gcd = numerator.gcd(denominator);
            return new Fraction(BigInteger.valueOf(shouldBeNegative ? -1 : 1).multiply(this.numerator.divide(gcd)), (this.denominator.divide(gcd)));
        }

        @Override
        public String toString() {
            return "(" + this.numerator + " / " + this.denominator + ")";
        }

        public boolean equals(Fraction other) {
            Fraction thisSimplified = this.simplified();
            Fraction otherSimplified = other.simplified();
            return thisSimplified.numerator.equals(otherSimplified.numerator) && thisSimplified.denominator.equals(otherSimplified.denominator);
        }
    }

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

    public static Fraction getNeededConvergent(int D) {
        Fraction baseFraction = new Fraction(1, 1);
        int length = 1;
        BigInteger added = BigInteger.valueOf(getFirstTerm(D));
        Fraction currentFraction = new Fraction(1, D - (long) getFirstTerm(D)*getFirstTerm(D));
        while (!currentFraction.equals(baseFraction)) {
            added = getNextAdded(added, currentFraction.denominator, D);
            currentFraction = new Fraction(currentFraction.denominator, BigInteger.valueOf(D).subtract(added.multiply(added))).simplified();
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
        currentFraction = new Fraction(1, D - (long) getFirstTerm(D)*getFirstTerm(D));
        for (int i = 1; i < terms.length; i++) {
            terms[i] = getNextTerm(added, currentFraction.denominator, D);
            added = getNextAdded(added, currentFraction.denominator, D);
            currentFraction = new Fraction(currentFraction.denominator, BigInteger.valueOf(D).subtract(added.multiply(added))).simplified();
        }

        Fraction fraction = new Fraction(BigInteger.ONE, terms[terms.length-1]);
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
