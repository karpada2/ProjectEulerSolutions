public final class P014 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P014().run());
    }

    public String run() {
        int bestNumber = 1;
        int bestLength = 1;
        int currLength = 0;
        for (int i = bestNumber; i < 1_000_000; i++) {
            currLength = UtilLibrary.getCollatzLength(i);
            if (currLength > bestLength) {
                bestLength = currLength;
                bestNumber = i;
            }
        }

        return Integer.toString(bestNumber);
    }
}
