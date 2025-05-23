import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class P026 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P026().run());
    }

    public String run() {
        int bestNumber = 0;
        int bestLength = 0;
        for (int i = 1; i <= 1000; i++) {
            int len = getCycleLength(i);
            if (len > bestLength) {
                bestNumber = i;
                bestLength = len;
            }
        }
        return Integer.toString(bestNumber);
    }


    private static int getCycleLength(int n) {
        Map<Integer,Integer> stateToIter = new HashMap<>();
        int state = 1;
        for (int iteration = 0; ; iteration++) {
            if (stateToIter.containsKey(state))
                return iteration - stateToIter.get(state);
            else {
                stateToIter.put(state, iteration);
                state = state * 10 % n;
            }
        }
    }
}