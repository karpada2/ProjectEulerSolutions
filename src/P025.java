import java.math.BigInteger;

public final class P025 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P025().run());
    }

    public String run() {
        BigInteger beforeLast = new BigInteger("1");
        BigInteger last = new BigInteger("1");
        BigInteger curr = last.add(beforeLast);

        long i;

        for (i = 2; curr.toString().length() < 1000; i++) {
            beforeLast = last;
            last = curr;
            curr = last.add(beforeLast);
        }

        return Long.toString(i+1);
    }
}
