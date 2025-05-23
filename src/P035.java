import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class P035 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P035().run());
    }

    public String run() {
        int[] allPrimes = UtilLibrary.getPrimesUpTo(999_999);
        Set<Integer> goodPrimes = HashSet.newHashSet(allPrimes.length);

        for (int i = 0; i < allPrimes.length; i++) {
            if (!goodPrimes.contains(allPrimes[i])) {
                if (isCircularPrime(allPrimes[i])) {
                    for (int j = 0; j < Math.floor(Math.log10(allPrimes[i])+1); j++) {
                        goodPrimes.add(UtilLibrary.circulateNumber(allPrimes[i], j));
                    }
                }
            }
        }

//        System.out.println(goodPrimes.toString());
        return Integer.toString(goodPrimes.size());
    }

    public static boolean isCircularPrime(int n) {
        int[] digits = UtilLibrary.breakIntoDigits(n);
        for (int i = 0; i < digits.length; i++) {
            int[] curr = UtilLibrary.circulateArray(digits, i);
            if (!UtilLibrary.isPrime(Integer.parseInt(UtilLibrary.digitsToIntegerString(curr)))) {
                return false;
            }
        }
        return true;
    }
}
