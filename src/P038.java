public final class P038 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P038().run());
    }


    public String run() {
        int max = 0;
        for (int n = 2; n < 10; n++) {
            for (int i = 1; i < 100_000; i++) {
                if (is9Pandigital(getConcatenation(i, n)) && Integer.parseInt(getConcatenation(i, n)) > max) {
                    max = Integer.parseInt(getConcatenation(i, n));
                }
            }
        }
        return Integer.toString(max);
    }

    public String getConcatenation(int num, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(i*num);
        }
        if (result.length() > 9) {
            return "0";
        }
        return result.toString();
    }

    public boolean is9Pandigital(String num) {
        if (num.length() != 9) {
            return false;
        }

        boolean[] appears = new boolean[9];

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                return false;
            }
            appears[num.charAt(i) - '0' - 1] = true;
        }

        for (int i = 0; i < appears.length; i++) {
            if (!appears[i]) {
                return false;
            }
        }
        return true;
    }
}
