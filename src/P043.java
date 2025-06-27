import java.math.BigInteger;

public final class P043 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P043().run());
    }

    public String run() {
        BigInteger sum = BigInteger.valueOf(0);
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        do {
            if (isDigitsWithUniqueProperty(number)) {
                sum = sum.add(new BigInteger(UtilLibrary.digitsToIntegerString(number)));
            }
        }
        while (UtilLibrary.nextPermutation(number));

        return sum.toString();
    }

    static int[] relevantPrimes = UtilLibrary.getPrimesUpTo(18);

    public static boolean isDigitsWithUniqueProperty(int[] digits) {
        return
                (digits[1]*100 + digits[2]*10 + digits[3]) % relevantPrimes[0] == 0 &&
                        (digits[2]*100 + digits[3]*10 + digits[4]) % relevantPrimes[1] == 0 &&
                                (digits[3]*100 + digits[4]*10 + digits[5]) % relevantPrimes[2] == 0 &&
                                        (digits[4]*100 + digits[5]*10 + digits[6]) % relevantPrimes[3] == 0 &&
                                                (digits[5]*100 + digits[6]*10 + digits[7]) % relevantPrimes[4] == 0 &&
                                                        (digits[6]*100 + digits[7]*10 + digits[8]) % relevantPrimes[5] == 0 &&
                                                                (digits[7]*100 + digits[8]*10 + digits[9]) % relevantPrimes[6] == 0;
    }
}
