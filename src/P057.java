import java.math.BigInteger;

public final class P057 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P057().run());
    }

    @Override
    public String run() {
        BigInteger x = BigInteger.valueOf(3);
        BigInteger y = BigInteger.TWO;
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (x.toString().length() > y.toString().length()) {
                count++;
            }
            BigInteger newX = (y.add(y)).add(x);
            BigInteger newY = y.add(x);
            x = newX;
            y = newY;
        }
        return Integer.toString(count);
    }
}
