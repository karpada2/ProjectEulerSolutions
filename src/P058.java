import java.util.Arrays;

public final class P058 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P058().run());
    }

    public static long assumedSideLength = 3;

    public static long countPrimesOnSideLength(long sideLength) {
        long diff = sideLength-1;
        long check = sideLength*sideLength;
        long count = 0;
        for (long i = 0; i < 4; i++) {
            count += UtilLibrary.isPrime(check) ? 1 : 0;
            check -= diff;
        }

        return count;
    }

    @Override
    public String run() {
        long countTotal = 1 + 4; // 1 being in the middle and the starting 4 corners
        long countPrimes = 0;
        while ((double)(countPrimesOnSideLength(assumedSideLength)+countPrimes)/(countTotal) > 0.1) {
            countPrimes += countPrimesOnSideLength(assumedSideLength);
            countTotal += 4;
            assumedSideLength += 2;
        }
        return Long.toString(assumedSideLength);
    }
}
