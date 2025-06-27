import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class P044 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P044().run());
    }

    public String run() {
        int limit = 10_000_000;

        Set<Integer> pentagonals = new HashSet<>();
        for (int i = 1; i < limit; i++) {
            if (isPentagonalNumber(i)) {
                pentagonals.add(i);
            }
        }

        Integer[] pentagonalsArray = pentagonals.toArray(new Integer[0]);

        Arrays.sort(pentagonalsArray);

        int bestPjIndex = -1;
        int bestPkIndex = -1;

        for (int PjIndex = 0; PjIndex < pentagonalsArray.length; PjIndex++) {
            for (int PkIndex = PjIndex+1; PkIndex < pentagonalsArray.length; PkIndex++) {
                if (pentagonals.contains(pentagonalsArray[PkIndex] + pentagonalsArray[PjIndex])) {
                    if (pentagonals.contains(Math.abs(pentagonalsArray[PkIndex] - pentagonalsArray[PjIndex]))) {
                        if (bestPjIndex == -1 || Math.abs(pentagonalsArray[PkIndex] - pentagonalsArray[PjIndex]) < Math.abs(pentagonalsArray[bestPkIndex] - pentagonalsArray[bestPjIndex])) {
                            bestPjIndex = PjIndex;
                            bestPkIndex = PkIndex;
                        }
                    }
                }
                else if (isPentagonalNumber(pentagonalsArray[PkIndex] + pentagonalsArray[PjIndex])) {
                    if (pentagonals.contains(Math.abs(pentagonalsArray[PkIndex] - pentagonalsArray[PjIndex]))) {
                        if (bestPjIndex == -1 || Math.abs(pentagonalsArray[PkIndex] - pentagonalsArray[PjIndex]) < Math.abs(pentagonalsArray[bestPkIndex] - pentagonalsArray[bestPjIndex])) {
                            bestPjIndex = PjIndex;
                            bestPkIndex = PkIndex;
                        }
                    }
                }
            }
        }

//        System.out.println("Best Pj = " + pentagonalsArray[bestPjIndex]);
//        System.out.println("Best Pk = " + pentagonalsArray[bestPkIndex]);
        return Integer.toString(Math.abs(pentagonalsArray[bestPkIndex] - pentagonalsArray[bestPjIndex]));
    }

    public static boolean isPentagonalNumber(int n) {
        if (n == 0) {
            return false;
        }
        for (int i = 1; i < (int)(Math.ceil(Math.sqrt(3*n))); i++) {
            if ((i*(3*i - 1))/2 == n) {
                return true;
            }
        }
        return false;
    }
}
