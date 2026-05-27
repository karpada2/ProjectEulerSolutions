import java.math.BigInteger;
import java.util.Arrays;

public final class P068 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P068().run());
    }

    public static int[] getRow(int[] pentagon, int index) {
        int[] result = new int[3];
        result[0] = pentagon[index];
        result[1] = pentagon[index+5];
        result[2] = pentagon[((index + 1) % 5) + 5];

        return result;
    }

    public static boolean isMagic(int[] pentagon) {
        int sum = (int)UtilLibrary.sum(getRow(pentagon, 0));
        boolean isAllValid = true;
        for (int i = 1; i < pentagon.length/2; i++) {
            if ((int)UtilLibrary.sum(getRow(pentagon, i)) != sum) {
                isAllValid = false;
            }
        }
        return isAllValid;
    }

    public static BigInteger getStringRepresentationAsNumber(int[] pentagon) {
        StringBuilder builder = new StringBuilder();

        int minIndex = 0;
        for (int i = 0; i < pentagon.length/2; i++) {
            if (pentagon[i] < pentagon[minIndex]) {
                minIndex = i;
            }
        }

        for (int i = 0; i < pentagon.length/2; i++) {
            int[] row = getRow(pentagon, (i+minIndex)%5);
            for (int j = 0; j < row.length; j++) {
                builder.append(row[j]);
            }
        }

        return new BigInteger(builder.toString());
    }

    public static boolean nextPermutation(int[] pentagon) {
        int[] clone = UtilLibrary.reverse(Arrays.copyOfRange(pentagon, 1, pentagon.length));
        boolean result = UtilLibrary.nextPermutation(clone);
        clone = UtilLibrary.reverse(clone);
        for (int i = 1; i < pentagon.length; i++) {
            pentagon[i] = clone[i-1];
        }
        return result;
    }

    @Override
    public String run() {
        int[] pentagon = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BigInteger biggestStringSoFar = BigInteger.ZERO;

        do {
            if (isMagic(pentagon)) {
                BigInteger currRepresentation = getStringRepresentationAsNumber(pentagon);
                if (currRepresentation.compareTo(biggestStringSoFar) > 0) {
                    biggestStringSoFar = currRepresentation;
                }
            }
        } while (nextPermutation(pentagon));

        return biggestStringSoFar.toString();
    }
}
