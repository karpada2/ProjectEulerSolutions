import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class P047 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P047().run());
    }

    public static int amount = 4;

    public String run() {
        for (int i = 1; i < 2_147_000_000; i++) {
            if (isDistinctNumber(amount, i) && isDistinctNumber(amount, i+1) && isDistinctNumber(amount, i+2) && isDistinctNumber(amount, i+3)) {
                return Integer.toString(i);
            }
        }
        return "";
    }

    public static boolean isDistinct(int amount, int[] arr) {
        Set<Integer> factors = new HashSet<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            factors.add(arr[i]);
        }

        return factors.size() >= amount;
    }

    public static boolean isDistinctNumber(int amount, int num) {
        return isDistinct(amount, UtilLibrary.getPrimeFactors(num));
    }
}
