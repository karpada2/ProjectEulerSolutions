public final class P040 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P040().run());
    }

    public String run() {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i <= 1_000_000; i++) {
            num.append(i);
        }

        int d1 = num.charAt(1) - '0';
        int d10 = num.charAt(10) - '0';
        int d100 = num.charAt(100) - '0';
        int d1_000 = num.charAt(1_000) - '0';
        int d10_000 = num.charAt(10_000) - '0';
        int d100_000 = num.charAt(100_000) - '0';
        int d1_000_000 = num.charAt(1_000_000) - '0';

        return Integer.toString(d1*d10*d100*d1_000*d10_000*d100_000*d1_000_000);
    }
}
