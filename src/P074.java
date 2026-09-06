import java.util.HashSet;

public class P074 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P074().run());
    }
    
    public static long getNext(long n) {
        long result = 0;
        while (n > 0) {
            result += UtilLibrary.factorial(n%10);
            n /= 10;
        }

        return result;
    }

    public static int UPPER_LIMIT = 1_000_000;

    @Override
    public String run() {
        HashSet<Long> seen = new HashSet();
        int count = 0;
        long curr;
        for (int i = 1; i <= UPPER_LIMIT; i++) {
            seen.clear();
            curr = i;
            while (!seen.contains(curr)) {
                seen.add(curr);
                curr = getNext(curr);
            }
            if (seen.size() == 60) {
                count++;
            }
//            System.out.println(i + ", " + seen.size());
        }
        return Integer.toString(count);
    }
}
