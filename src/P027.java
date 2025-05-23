import java.util.Arrays;

public final class P027 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P027().run());
    }

    public String run() {
        int[] primesUpTo1000 = UtilLibrary.getPrimesUpTo(1000);

        int bestNumber = 0;
        int bestProduct = 0;
        for (int a : primesUpTo1000) {
            for (int b : primesUpTo1000) {
                for (int aMult = -1; aMult < 2; aMult += 2) {
                    for (int bMult = -1; bMult < 2; bMult += 2) {
                        if (getMaxNumberThatWorks(a * aMult, b * bMult) > bestNumber) {
                            bestProduct = a * aMult * b * bMult;
                            bestNumber = getMaxNumberThatWorks(a * aMult, b * bMult);
                        }
                    }
                }
            }
        }

        return Integer.toString(bestProduct);
    }

    public int getMaxNumberThatWorks(int a, int b) {
        for (int n = 0; ; n++) {
            if ((n*n)+(a*n)+b <= 0) {
                return n;
            }
            if ((n*n)+(a*n)+b > 0 && !UtilLibrary.isPrime((n*n)+(a*n)+b)) {
                return n;
            }
        }

    }
}
