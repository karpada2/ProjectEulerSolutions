import java.util.HashSet;
import java.util.Set;

public final class P032 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P032().run());
    }

    public String run() {
        Set<Integer> seenProducts = new HashSet<>();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;
        do {
            for (int timesIndex = 1; timesIndex < numbers.length-1; timesIndex++) {
                for (int equalsIndex = timesIndex+1; equalsIndex < numbers.length; equalsIndex++) {
                    if (
                        concatenateIntArrFromIndexes(numbers, 0, timesIndex)
                        * concatenateIntArrFromIndexes(numbers, timesIndex, equalsIndex)
                        == concatenateIntArrFromIndexes(numbers, equalsIndex, numbers.length)
                        && !seenProducts.contains(concatenateIntArrFromIndexes(numbers, equalsIndex, numbers.length))
                    )
                    {
//                        System.out.println(concatenateIntArrFromIndexes(numbers, 0, timesIndex) + " * " + concatenateIntArrFromIndexes(numbers, timesIndex, equalsIndex) + " = " + concatenateIntArrFromIndexes(numbers, equalsIndex, numbers.length));
                        seenProducts.add(concatenateIntArrFromIndexes(numbers, equalsIndex, numbers.length));
                        sum += concatenateIntArrFromIndexes(numbers, equalsIndex, numbers.length);
                    }
                }
            }
        }
        while (UtilLibrary.nextPermutation(numbers));

        return Integer.toString(sum);
    }

    // start index is inclusive, stop index is exclusive
    public int concatenateIntArrFromIndexes(int[] arr, int startIndex, int stopIndex) {
        int built = 0;
        for (int i = startIndex; i < stopIndex; i++) {
            built *= 10;
            built += arr[i];
        }
        return built;
    }
}
