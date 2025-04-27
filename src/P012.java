import java.util.Arrays;

public final class P012 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P012().run());
    }

    public String run() {
        for (int i = 1; ; i++) {
            if (UtilLibrary.getDivisors(UtilLibrary.sumOfIntegersUpTo(i)).length > 500) {
                return Integer.toString(UtilLibrary.sumOfIntegersUpTo(i));
            }
        }
    }
}
