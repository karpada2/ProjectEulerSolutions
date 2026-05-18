public final class P052 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P052().run());
    }

    public static int LOWER_BOUND = 1000;
    public static int[] multiples = {2, 3, 4, 5, 6};

    public static long getLowerBoundForDigitAmount(int digitAmount) {
        return (long)Math.pow(10, digitAmount-1);
    }

    public static boolean isTooBig(long number) {
        return UtilLibrary.countDigits(number) != UtilLibrary.countDigits(number * multiples[multiples.length-1]);
    }

    public static boolean isValid(long number) {
        for (int i = 0; i < multiples.length; i++) {
            if (!UtilLibrary.isPermutationOf(number, multiples[i] * number)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String run() {
        for (long x = LOWER_BOUND; true; x++) {
            if (isTooBig(x)) {
                x = getLowerBoundForDigitAmount(UtilLibrary.countDigits(x)+1);
            }
            if (isValid(x)) {
                return Long.toString(x);
            }
        }
    }
}
