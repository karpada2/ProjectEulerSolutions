import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class P045 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P045().run());
    }

    private static int seeds = 100_000;

    public String run() {
        Set<BigInteger> triangles = new HashSet<>();
        Set<BigInteger> pentagonals = new HashSet<>();
        Set<BigInteger> hexagonals = new HashSet<>();

        for (int i = 1; i < seeds; i++) {
            triangles.add(getTriangleNumber(i));
            pentagonals.add(getPentagonalNumber(i));
            hexagonals.add(getHexagonalNumber(i));
        }

        BigInteger[] triangleArray = triangles.toArray(new BigInteger[]{});
        for (int i = 0; i < triangleArray.length; i++) {
            if (triangleArray[i].compareTo(BigInteger.valueOf(40755)) > 0 && pentagonals.contains(triangleArray[i]) && hexagonals.contains(triangleArray[i])) {
                return triangleArray[i].toString();
            }
        }

        return "fuck you";
    }

    public static BigInteger getTriangleNumber(int n) {
        BigInteger num = BigInteger.valueOf(n);
        return (num.multiply(num.add(BigInteger.ONE))).divide(BigInteger.TWO);
    }

    public static BigInteger getPentagonalNumber(int n) {
        BigInteger num = BigInteger.valueOf(n);
        return (num.multiply(num.multiply(BigInteger.valueOf(3)).subtract(BigInteger.ONE))).divide(BigInteger.TWO);
    }

    public static BigInteger getHexagonalNumber(int n) {
        BigInteger num = BigInteger.valueOf(n);
        return (num.multiply(num.multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE)));
    }
}
