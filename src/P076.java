import org.testng.internal.collections.Pair;

import java.math.BigInteger;
import java.util.*;

public final class P076 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P076().run());
    }

    public static int num = 100;

    // maps between a pair<currSum, startIndex> to the corresponding value
    public static HashMap<Pair<Integer, Integer>, BigInteger> cache = new HashMap<>();

    public static BigInteger getPartitions(int n, int currSum, int indexToWorkOn) {
        if (currSum == n) {
            cache.put(new Pair<>(currSum, indexToWorkOn), BigInteger.ONE);
            return BigInteger.ONE;
        }
        if (indexToWorkOn <= 0) {
            return BigInteger.ZERO;
        }


        if (cache.containsKey(new Pair<Integer, Integer>(currSum, indexToWorkOn))) {
            return cache.get(new Pair<>(currSum, indexToWorkOn));
        }
        BigInteger counter = BigInteger.ZERO;

        for (int i = 0; currSum + (i*indexToWorkOn) <= n; i++) {
            counter = counter.add(getPartitions(n, currSum + (i*indexToWorkOn), indexToWorkOn - 1));
        }

        cache.put(new Pair<>(currSum, indexToWorkOn), counter);

        return counter;
    }

    @Override
    public String run() {
        BigInteger count = getPartitions(num, 0, num - 1);
        return count.toString();
    }
}
