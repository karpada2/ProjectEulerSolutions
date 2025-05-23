public final class P020 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P020().run());
    }

    public String run() {
        return Integer.toString(UtilLibrary.sumDigits(UtilLibrary.factorialBigInteger(100)));
    }
}
