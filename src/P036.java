public final class P036 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P036().run());
    }

    public String run() {
        int sum = 0;
        for (int i = 1; i < 999_999; i++) {
            if (UtilLibrary.isPalindrome(Integer.toString(i)) && UtilLibrary.isPalindrome(UtilLibrary.stripZeroesFromStart(Integer.toBinaryString(i)))) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }
}
