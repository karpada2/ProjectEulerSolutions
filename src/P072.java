import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public final class P072 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P072().run());
    }

    public static int UPPER_LIMIT = 1_000_000;
    public static int[] totients = UtilLibrary.listTotients(UPPER_LIMIT);

    @Override
    public String run() {
        long count = 0;
        for (int denominator = 2; denominator <= UPPER_LIMIT; denominator++) {
            count += totients[denominator];
        }

        return Long.toString(count);
    }
}
