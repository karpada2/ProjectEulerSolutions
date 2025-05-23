public final class P030 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P030().run());
    }

    public String run() {
        int sum = 0;
        for (int i = 2; i < 1_000_000; i++) {
            if (sumOfFifthPowersOfDigits(i) == i) {
                sum += i;
            }
        }

        return Integer.toString(sum);
    }

    public int sumOfFifthPowersOfDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        if (num < 10) {
            return (int)(Math.pow(num, 5));
        }
        return sumOfFifthPowersOfDigits(num/10) + (int)(Math.pow(num%10, 5));
    }
}
