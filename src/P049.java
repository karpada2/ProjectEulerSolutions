import java.util.HashSet;
import java.util.Set;

public final class P049 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P049().run());
    }

    public String run() {
        Set<Integer> primes = new HashSet<>();
        int[] primeArray = UtilLibrary.getPrimesUpTo(10_000);

        // what index has the first number above 
        int startIndex = 0;

        return "";
    }
}
