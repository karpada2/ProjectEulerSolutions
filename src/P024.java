public final class P024 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P024().run());
    }

    public String run() {
        int[] startingPermutation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 999_999; i++) {
            if (!UtilLibrary.nextPermutation(startingPermutation)) {
                throw new RuntimeException("There is no 1 millionth permutation!");
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < startingPermutation.length; i++) {
            out.append(startingPermutation[i]);
        }
        return out.toString();
    }
}
