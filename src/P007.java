public final class P007 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P007().run());
    }

    public String run() {
        int primeCount = 0;
        for (int i = 2; ; i++) {
            if (UtilLibrary.isPrime(i)) {
                primeCount++;
            }
            if (primeCount == 10_001) {
                return Integer.toString(i);
            }
        }
    }
}
