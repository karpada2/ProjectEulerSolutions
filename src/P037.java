import java.util.Set;

public final class P037 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P037().run());
    }

    static int size = 1_000_000;
    static Set<Integer> primes = UtilLibrary.arrToHashSet(UtilLibrary.getPrimesUpTo(size));

    public String run() {
        int sum = 0;
        int amount = 0;
        int[] primesArray = UtilLibrary.getPrimesUpTo(size);
        for (int i = 0; i < primesArray.length; i++) {
            if (primesArray[i] >= 10) {
                if (isTruncatableLeft(primesArray[i]) && isTruncatableRight(primesArray[i])) {
                    sum += primesArray[i];
                    amount++;
                }
            }
        }
        return Integer.toString(sum);
    }

    // from left to right
    public static boolean isTruncatableLeft(int n) {
        do {
            if (!primes.contains(n)) {
                return false;
            }

            n = UtilLibrary.circulateNumber(n, -1)/10;
        }
        while (n > 0);

        return true;
    }

    // from left to right
    public static boolean isTruncatableRight(int n) {
        do {
            if (!primes.contains(n)) {
                return false;
            }

            n = n/10;
        }
        while (n > 0);

        return true;
    }
}
