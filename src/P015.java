import java.math.BigInteger;

public final class P015 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P015().run());
    }

    public String run() {
        return UtilLibrary.choose(40, 20).toString();
    }
}
