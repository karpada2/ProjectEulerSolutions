public final class P004 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P004().run());
    }

    public String run() {
        int largestFound = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = i; j < 1000; j++) {
                if (i*j > largestFound && UtilLibrary.isPalindrome(Integer.toString(i*j))) {
                    largestFound = i*j;
                }
            }
        }
        return Integer.toString(largestFound);
    }
}
