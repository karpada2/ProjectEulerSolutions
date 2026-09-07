import org.testng.internal.collections.Pair;

import java.math.BigInteger;
import java.util.HashMap;

public final class P077 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P077().run());
    }

    public static int[] primes = UtilLibrary.getPrimesUpTo(1_000_000);

    public static long reach = 5_000;

    public static BigInteger getPartitions(int n, int currSum, int indexToWorkOn) {
        if (currSum == n) {
            return BigInteger.ONE;
        }
        if (indexToWorkOn >= primes.length || primes[indexToWorkOn] > n) {
            return BigInteger.ZERO;
        }


        BigInteger counter = BigInteger.ZERO;

        for (int i = 0; currSum + (i*primes[indexToWorkOn]) <= n; i++) {
            counter = counter.add(getPartitions(n, currSum + (i*primes[indexToWorkOn]), indexToWorkOn + 1));
        }


        return counter;
    }

    @Override
    public String run() {
        BigInteger count = getPartitions(10, 0, 0);
        int max = 10;
        for (int i = 11; count.compareTo(BigInteger.valueOf(reach)) <= 0; i++) {
            count = getPartitions(i, 0, 0);
            max = i;
        }
        return Integer.toString(max);
    }
}
