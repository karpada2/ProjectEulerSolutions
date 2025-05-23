import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public final class P029 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P029().run());
    }

    static int minValue = 2;
    static int maxValue = 100;
    public String run() {
        Set<BigInteger> results = new HashSet<>();
        for (int a = minValue; a <= maxValue; a++) {
            for (int b = minValue; b <= maxValue; b++) {
                results.add(BigInteger.valueOf(a).pow(b));
            }
        }

        return Integer.toString(results.size());
    }
}
