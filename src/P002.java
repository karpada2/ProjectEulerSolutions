public final class P002 implements Solution{
    public static void main(String[] args) {
        System.out.println(new P002().run());
    }

    public String run() {
        int sum = 0;
        int lastFibonacci = UtilLibrary.fibonacci(0);
        for (int i = 1; lastFibonacci < 4E6; i++) {
            if (lastFibonacci%2 == 0) {
                sum += lastFibonacci;
            }
            lastFibonacci = UtilLibrary.fibonacci(i);
        }
        return Integer.toString(sum);
    }
}
