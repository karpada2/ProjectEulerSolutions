import java.math.BigInteger;

public final class P056 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P056().run());
    }

    @Override
    public String run() {
        int maxDigitSum = -1;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                BigInteger result = BigInteger.valueOf(a).pow(b);
                int digitSum = UtilLibrary.sumDigits(result);
                if (digitSum > maxDigitSum) {
                    maxDigitSum = digitSum;
                }
            }
        }
        return Integer.toString(maxDigitSum);
    }
}
