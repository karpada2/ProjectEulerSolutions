public final class P070 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P070().run());
    }

    public static int UPPER_BOUND = 10_000_001;
    public static boolean[] primality = UtilLibrary.listPrimality(UPPER_BOUND);
    public static int[] primes = UtilLibrary.getPrimesUpTo(UPPER_BOUND);

    public static int totient(int n) {
        if (n <= 0) {
            return -1;
        }
        if (primality[n]) {
            return n-1;
        }



        int result = n;
        for (int i = 0; primes[i]*primes[i] < n; i++) {
            int p = primes[i];
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result/p;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static boolean isSmaller(long numerator1, long denominator1, long numerator2, long denominator2) {
        return numerator1*denominator2 < numerator2*denominator1;
    }

    @Override
    public String run() {
        int minN = 2;
        int minTotient = totient(minN);
        for (int i = 3; i < UPPER_BOUND; i++) {
            int totient = totient(i);
            if (isSmaller(i, totient, minN, minTotient) && UtilLibrary.isPermutationOf(i, totient)) {
                minN = i;
                minTotient = totient;
            }
        }

        return Integer.toString(minN);
    }
}
