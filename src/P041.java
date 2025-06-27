import java.util.Arrays;

public final class P041 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P041().run());
    }

    public String run() {
        int[] primes = UtilLibrary.getPrimesUpTo(123456790);
        int maxIndex = 0;
        for (int i = 0; i < primes.length; i++) {
            if (UtilLibrary.isPanDigital(primes[i]) && primes[i] > primes[maxIndex]) {
                maxIndex = i;
            }
        }

        return Integer.toString(primes[maxIndex]);
    }
}
