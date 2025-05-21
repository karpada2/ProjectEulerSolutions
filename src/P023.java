import java.util.Arrays;

public final class P023 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P023().run());
    }

    static int upperLimit = 28_123;

    boolean[] isAbundant = new boolean[upperLimit+1];

    public String run() {
        for (int i = 1; i < isAbundant.length; i++) {
            isAbundant[i] = UtilLibrary.isAbundant(i);
        }

        int sum = 0;
        for (int i = 1; i <= upperLimit; i++) {
            if (!isSumOfTwoAbundant(i)) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }

    private boolean isSumOfTwoAbundant(int n) {
        for (int i = 1; i <= n; i++) {
            if (isAbundant[i] && isAbundant[n-i]) {
                return true;
            }
        }
        return false;
    }
}
