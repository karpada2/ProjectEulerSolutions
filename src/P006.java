public final class P006 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P006().run());
    }

    final static int n = 100;
    public String run() {
        int sumOfSquare = (n*(n+1)*((2*n)+1))/6;
        int squareOfSum = (n*n*(n+1)*(n+1))/4;

        return Integer.toString(Math.abs(sumOfSquare-squareOfSum));
    }
}
