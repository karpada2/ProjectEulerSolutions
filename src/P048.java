import java.math.BigInteger;

public final class P048 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P048().run());
    }

    public String run() {
        BigInteger modulo = BigInteger.TEN.pow(10);
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 1; i < 1000; i++) {
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), modulo));
        }

        if (sum.toString().length() > 10) {
            sum = sum.mod(modulo);
        }
        return sum.toString();
    }
}
