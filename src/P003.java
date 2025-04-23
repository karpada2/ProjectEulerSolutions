public final class P003 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P003().run());
    }

    public String run() {
        long num = 600_851_475_143L;
        long[] primeFactors = UtilLibrary.getPrimeFactors(num);
        return Long.toString(primeFactors[primeFactors.length-1]);
    }
}
