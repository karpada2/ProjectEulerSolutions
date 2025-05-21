import java.util.ArrayList;
import java.util.Arrays;

public final class P021 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P021().run());
    }


    public String run() {
        ArrayList<Integer> amicablePairs = new ArrayList<>();
        for (int i = 1; i <= 10_000; i++) {
            int b = getSumOfProperDivisors(i);
            if (getSumOfProperDivisors(b) == i && !UtilLibrary.has(amicablePairs, i)) {
                if (i != b) {
                    amicablePairs.add(i);
                    amicablePairs.add(b);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < amicablePairs.size(); i++) {
            sum += amicablePairs.get(i);
        }

        return Integer.toString(sum);
    }

    public int getSumOfProperDivisors(int n) {
        int num = 0;
        int[] divisors = UtilLibrary.getDivisors(n);
        for (int i = 0; i < divisors.length; i++) {
            num += divisors[i];
        }
        return num;
    }
}
