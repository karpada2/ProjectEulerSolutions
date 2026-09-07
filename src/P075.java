import java.util.ArrayList;

public final class P075 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P075().run());
    }

    public static final int UPPER_LIMIT = 1_500_000;
    public static int[] possibleTriangles = new int[UPPER_LIMIT + 1];

    public int[] getPrimitiveTriple(int m, int n) {
        if (UtilLibrary.gcd(m, n) != 1) {
            return new int[0];
        }
        if (m*n % 2 == 0) {
            return new int[]{
                    ((m * m) - (n * n))/2,
                    m*n,
                    ((m * m) + (n * n))/2,
            };
        }
        return new int[]{
                m*n,
                ((m * m) - (n * n))/2,
                ((m * m) + (n * n))/2,
        };
    }

    public int[] getPerimeters(int[] primitiveTriple) {
        if (primitiveTriple.length == 0) {
            return new int[0];
        }
        int primitivePerimeter = 0;
        for (int i = 0; i < primitiveTriple.length; i++) {
            primitivePerimeter += primitiveTriple[i];
        }

        int[] perimeters = new int[(UPPER_LIMIT/primitivePerimeter) + 10];
        for (int i = 0; (i+1)*primitivePerimeter <= UPPER_LIMIT; i++) {
            perimeters[i] = (i+1)*primitivePerimeter;
        }

        return perimeters;
    }

    @Override
    public String run() {
        int count = 0;


        for (int m = 3; m*m <= UPPER_LIMIT; m += 2) {
            for (int n = m - 2; n > 0; n -= 2) {
                int[] primitiveTriple = getPrimitiveTriple(m, n);
                int[] indexes = getPerimeters(primitiveTriple);
                for (int i = 0; i < indexes.length; i++) {
                    possibleTriangles[indexes[i]] = Math.min(possibleTriangles[indexes[i]] + 1, 2);
                }
            }
        }

        for (int i = 1; i < possibleTriangles.length; i++) {
            if (possibleTriangles[i] == 1) {
                count++;
            }
        }

        return Integer.toString(count);
    }
}
