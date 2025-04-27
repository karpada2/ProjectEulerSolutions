public final class P016 implements Solution {
    public static void main(String[] args) {
        int num = 1;
        for (int i = 0; i < 16; i++) {
            System.out.println("num: " + num + " - " + sumDigits(Integer.toString(num)));
            num *= 2;
        }
    }

    public String run() {
        return "";
    }

    public static int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}
