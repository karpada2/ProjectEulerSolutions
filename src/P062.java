import jdk.jshell.execution.Util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class P062 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P062().run());
    }

    public String sortDigitsOfCube(int x) {
        char[] digits = cube(x).toString().toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }

    public BigInteger cube(int x) {
        return BigInteger.valueOf(x).pow(3);
    }

    @Override
    public String run() {
        Map<String, Integer> lowest = new HashMap<>(1000);
        Map<String, Integer> counts = new HashMap<>(1000);
        for (int i = 0; ; i++) {
            String sortedDigits = sortDigitsOfCube(i);
            if (!lowest.containsKey(sortedDigits)) {
                lowest.put(sortedDigits, i);
                counts.put(sortedDigits, 1);
            }
            else {
                if (counts.get(sortedDigits) == 4) {
                    return cube(lowest.get(sortedDigits)).toString();
                }
                counts.replace(sortedDigits, counts.get(sortedDigits)+1);
            }
        }
    }
}
