import java.util.ArrayList;
import java.util.Arrays;

public final class P060 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P060().run());
    }

    public static int HIGH_BOUND = 10_000;
    public static int[] primes = UtilLibrary.getPrimesUpTo(HIGH_BOUND);
    public static boolean[] primality = UtilLibrary.listPrimality(HIGH_BOUND*HIGH_BOUND);

    public static int concatenateNumbers(int num1, int num2) {
        return num1*((int)Math.pow(10, UtilLibrary.countDigits(num2))) + num2;
    }

    @Override
    public String run() {
        ArrayList<int[]> validCombinations = new ArrayList<>(HIGH_BOUND/10);
        for (int aIndex = 0; aIndex < primes.length; aIndex++) {
            for (int bIndex = aIndex+1; bIndex < primes.length; bIndex++) {
                if (primality[concatenateNumbers(primes[aIndex], primes[bIndex])] && primality[concatenateNumbers(primes[bIndex], primes[aIndex])]) {
                    validCombinations.add(new int[]{primes[aIndex], primes[bIndex]});
                }
            }
        }

        ArrayList<int[]> newValidCombinations = new ArrayList<>(validCombinations.size());
        for (int i = 0; i < validCombinations.size(); i++) {
            int[] combo = validCombinations.get(i);
            for (int j = 0; j < primes.length; j++) {
                boolean valid = true;
                for (int k = 0; k < combo.length; k++) {
                    if (primes[j] == combo[k]) {
                        valid = false;
                    }
                }
                if (valid) {
                    boolean allPrime = true;
                    for (int k = 0; k < combo.length; k++) {
                        if (!(primality[concatenateNumbers(combo[k], primes[j])] && primality[concatenateNumbers(primes[j], combo[k])])) {
                            allPrime = false;
                        }
                    }
                    if (allPrime) {
                        newValidCombinations.add(new int[]{combo[0], combo[1], primes[j]});
                    }
                }
            }
        }
        validCombinations = newValidCombinations;

        newValidCombinations = new ArrayList<>(validCombinations.size());
        for (int i = 0; i < validCombinations.size(); i++) {
            int[] combo = validCombinations.get(i);
            for (int j = 0; j < primes.length; j++) {
                boolean valid = true;
                for (int k = 0; k < combo.length; k++) {
                    if (primes[j] == combo[k]) {
                        valid = false;
                    }
                }
                if (valid) {
                    boolean allPrime = true;
                    for (int k = 0; k < combo.length; k++) {
                        if (!(primality[concatenateNumbers(combo[k], primes[j])] && primality[concatenateNumbers(primes[j], combo[k])])) {
                            allPrime = false;
                        }
                    }
                    if (allPrime) {
                        newValidCombinations.add(new int[]{combo[0], combo[1], combo[2], primes[j]});
                    }
                }
            }
        }
        validCombinations = newValidCombinations;

        newValidCombinations = new ArrayList<>(validCombinations.size());
        for (int i = 0; i < validCombinations.size(); i++) {
            int[] combo = validCombinations.get(i);
            for (int j = 0; j < primes.length; j++) {
                boolean valid = true;
                for (int k = 0; k < combo.length; k++) {
                    if (primes[j] == combo[k]) {
                        valid = false;
                    }
                }
                if (valid) {
                    boolean allPrime = true;
                    for (int k = 0; k < combo.length; k++) {
                        if (!(primality[concatenateNumbers(combo[k], primes[j])] && primality[concatenateNumbers(primes[j], combo[k])])) {
                            allPrime = false;
                        }
                    }
                    if (allPrime) {
                        newValidCombinations.add(new int[]{combo[0], combo[1], combo[2], combo[3], primes[j]});
                    }
                }
            }
        }

        long minSum = Integer.MAX_VALUE;
        for (int i = 0; i < newValidCombinations.size(); i++) {
            if (UtilLibrary.sum(newValidCombinations.get(i)) < minSum) {
                minSum = UtilLibrary.sum(newValidCombinations.get(i));
            }
        }

        return Long.toString(minSum);
    }
}
