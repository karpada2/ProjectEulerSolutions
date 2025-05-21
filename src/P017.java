import java.math.BigInteger;

public final class P017 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P017().run());
    }

    public String run() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            String out = numToName(i);
//            System.out.println(out);
            sum += out.length();
        }
        return Integer.toString(sum);
    }


    // only defined for 1-1000 cuz fuck off
    public String numToName(int num) {
        int length = Integer.toString(num).length();
        StringBuilder builder = new StringBuilder();

        if (length == 4) {
            builder.append("OneThousand");
            num = num % 1000;
        }

        if ((num/100) != 0) {
            builder.append(ONES[num/100]);
            builder.append("Hundred");
            num = num%100;
            if (!(num/10 == 0 && num%10 == 0)) {
                builder.append("And");
            }
        }

        if (num/10 != 0) {
            if (num/10 == 1) {
                builder.append(TEENS[num%10]);
            }
            else {
                builder.append(TENS[num/10]);
                builder.append(ONES[num%10]);
            }
        }
        else if (num%10 != 0) {
            builder.append(ONES[num%10]);
        }

        return builder.toString();
    }

    public static String[] ONES = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine"
    };

    public static String[] TEENS = {
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    public static String[] TENS = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };
}
