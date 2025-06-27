import java.util.HashSet;
import java.util.Set;

public final class P046 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P046().run());
    }

    private static int limit = 10_000;
    private static int[] primes = UtilLibrary.getPrimesUpTo(limit);

    public String run() {
        Set<Integer> primeSet = new HashSet<>();
        for (int i = 0; i < primes.length; i++) {
            primeSet.add(primes[i]);
        }

        for (int result = 9; result < limit; result+=2) {
            while (primeSet.contains(result)) {
                result+=2;
            }

            if (!canBeWrittenAsSum(result)) {
                return Integer.toString(result);
            }
        }

        return "FUCK YOU";
    }

    public static boolean canBeWrittenAsSum(int n) {
        for (int i = 0; i < primes.length && primes[i] < n; i++) {
            for (int j = 0; 2*j*j <= n-primes[i]; j++) {
                if (n == primes[i]+2*j*j) {
                    return true;
                }
            }
        }
        return false;
    }
}
