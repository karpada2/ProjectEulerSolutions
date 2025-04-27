public final class P010 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P010().run());
    }

    public String run() {
        long sum = 0;
        for (int i = 2; i < 2_000_000; i++) {
            if (UtilLibrary.isPrime(i)) {
                sum += i;
            }
        }
        return Long.toString(sum);
    }
}
