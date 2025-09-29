import java.util.HashSet;
import java.util.Set;

public final class P049 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P049().run());
    }

    public String run() {
        int[] primes = UtilLibrary.getPrimesUpTo(10_000);

        for (int i = 0; i < primes.length-2; i++) {
            for (int j = i+1; j < primes.length-1; j++) {
                for (int k = j+1; k < primes.length; k++) {
                    if (
                            UtilLibrary.isPermutationOf(UtilLibrary.breakIntoDigits(primes[i]), UtilLibrary.breakIntoDigits(primes[j])) &&
                                    UtilLibrary.isPermutationOf(UtilLibrary.breakIntoDigits(primes[j]), UtilLibrary.breakIntoDigits(primes[k])) &&
                                    primes[k] - primes[j] == primes[j] - primes[i]
                    ) {
                        if (primes[i] != 1487) {
                            return Integer.toString(primes[i]) + Integer.toString(primes[j]) + Integer.toString(primes[k]);
                        }
                    }
                }
            }
        }

        return "";
    }
}
