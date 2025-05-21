import java.math.BigInteger;

public final class P016 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P016().run());
    }

    public String run() {
        String number = BigInteger.ONE.shiftLeft(1000).toString();
        return sumDigits(number).toString();
    }

    public static BigInteger sumDigits(String num) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < num.length(); i++) {
            result = result.add(BigInteger.valueOf(num.charAt(i) - '0'));
        }
        return result;
    }
}
