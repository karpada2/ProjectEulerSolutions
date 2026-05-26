import java.math.BigInteger;
import java.util.Arrays;

public final class P065 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P065().run());
    }

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
            return add(BigInteger.valueOf(number).multiply(this.denominator), this.denominator);
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
            return thisSimplified.numerator == otherSimplified.numerator && thisSimplified.denominator == otherSimplified.denominator;
        }
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

        Fraction fraction = new Fraction(1, terms[terms.length-1]);
        for (int i = terms.length-2; i >= 0; i--) {
            fraction = fraction.add(terms[i]).inverse();
        }
        fraction = fraction.inverse();

        System.out.println(fraction);

        return Long.toString(UtilLibrary.sumDigits(fraction.numerator));
    }
}
