import java.util.ArrayList;
import java.util.HashSet;

public final class P064 implements Solution {
    public static class Fraction {
        long numerator;
        long denominator;

        public Fraction(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction times(Fraction other) {
            return this.times(other.numerator, other.denominator);
        }
        public Fraction times(long numerator, long denominator) {
            return new Fraction(this.numerator * numerator, this.denominator * denominator);
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

        public Fraction add(long numerator, long denominator) {
            if (this.denominator == denominator) {
                return new Fraction(this.numerator + numerator, denominator);
            }
            return new Fraction(this.numerator*denominator + numerator*this.denominator, this.denominator*denominator);
        }
        public Fraction add(Fraction other) {
            return add(other.numerator, other.denominator);
        }

        public Fraction simplified() {
            boolean shouldBeNegative = (this.numerator < 0) ^ (this.denominator < 0);
            long gcd = UtilLibrary.gcd(numerator, denominator);
            return new Fraction((shouldBeNegative ? -1 : 1)*(this.numerator/gcd), (this.denominator/gcd));
        }

        @Override
        public String toString() {
            return "(" + this.numerator + " / " + this.denominator + ")";
        }

        public boolean equals(Fraction other) {
            Fraction thisSimplified = this.simplified();
            Fraction otherSimplified = other.simplified();
            return thisSimplified.numerator == otherSimplified.numerator && thisSimplified.denominator == otherSimplified.denominator;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P064().run());
    }

    public static int UPPER_BOUND = 10_000;
    public static Fraction baseFraction = new Fraction(1, 1);

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
                Fraction currentFraction = new Fraction(1, i - (long) getFirstTerm(i)*getFirstTerm(i));
                while (!currentFraction.equals(baseFraction)) {
                    added = getNextAdded(added, currentFraction.denominator, i);
                    currentFraction = new Fraction(currentFraction.denominator, i - added*added).simplified();
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
