import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public final class P034 implements Solution {
    private static class Factorial implements IntUnaryOperator {
        @Override
        public int applyAsInt(int operand) {
            return UtilLibrary.factorial(operand);
        }
    }


    public static void main(String[] args) {
        System.out.println(new P034().run());
    }

    public String run() {
        int sum = 0;
        for (int i = 3; i < 100_000; i++) {
            if (UtilLibrary.sum(UtilLibrary.applyToAll(UtilLibrary.breakIntoDigits(i), new Factorial())) == i) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }
}
