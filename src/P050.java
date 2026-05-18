import java.util.*;

public final class P050 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P050().run());
    }

    private static long[] relevantPrimes = UtilLibrary.getPrimesUpTo(1_000_000L);
    private static boolean[] isPrimeLookup = UtilLibrary.listPrimality(1_000_000);

    @Override
    public String run() {
        int longestLength = 1;
        long primeWithLongest = 2;
        for (int i = 0; i < relevantPrimes.length; i++) {
            long currentSumPrime = relevantPrimes[i];
            for (int j = i+1; j < relevantPrimes.length; j++) {
                currentSumPrime += relevantPrimes[j];
                if (currentSumPrime <= 1_000_000 && (j - i) + 1 > longestLength && isPrimeLookup[(int)currentSumPrime]) {
                    longestLength = (j - i) + 1;
                    primeWithLongest = currentSumPrime;
                }
            }
        }

        return Long.toString(primeWithLongest);
    }
}
