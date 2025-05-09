import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

public class UtilLibrary {

    public static int charToInt(char c) {
        return c-48;
    }

    public static char intToChar(int n) {
        return (char)(n+48);
    }

    public static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int end = arr.length-1, start = 0; end >= 0; end--, start++) {
            newArr[start] = arr[end];
        }
        return newArr;
    }

    public static String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public static int[] join(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            newArr[i] = arr2[i-arr1.length];
        }
        return newArr;
    }


    public static int[] toArrayInt(LinkedList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static long[] toArrayLong(LinkedList<Long> list) {
        long[] arr = new long[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int[] clone(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    // 0 returns 0, 1 returns 1, 2 returns 1, 3 returns 2, 4 returns 3, 5 returns 5, 6 returns 8 and so on
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int oneBeforeLast = 0; // fibonacci(i-2)
        int last = 1; // fibonacci(i-1)
        int curr = oneBeforeLast + last; // fibonacci(i)

        for (int i = 0; i < n-1; i++) {
            last = curr;
            curr = oneBeforeLast + last;
            oneBeforeLast = last;
        }

        return curr;
    }

    public static boolean isPrime(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return false;
        }

        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0 && i != 1 && i != n) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(long n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return false;
        }

        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0 && i != 1 && i != n) {
                return false;
            }
        }
        return true;
    }

    public static long[] getPrimeFactors(long n) {
        if (isPrime(n)) {
            return new long[]{1, n};
        }
        LinkedList<Long> factorsSmallerThanSqrt = new LinkedList<Long>();

        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0 && isPrime(i)) {
                long num = n;
                while (num%i == 0) {
                    num /= i;
                    factorsSmallerThanSqrt.add((long)(i));
                }
            }
        }

        return toArrayLong(factorsSmallerThanSqrt);
    }

    public static int[] getPrimeFactors(int n) {
        if (isPrime(n)) {
            return new int[]{1, n};
        }
        LinkedList<Integer> factorsSmallerThanSqrt = new LinkedList<Integer>();

        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0 && isPrime(i)) {
                int num = n;
                while (num%i == 0) {
                    num /= i;
                    factorsSmallerThanSqrt.add(i);
                }
            }
        }

        return toArrayInt(factorsSmallerThanSqrt);
    }

    public static int[] getDivisors(int n) {
        LinkedList<Integer> firstHalfOfDivisors = new LinkedList<Integer>();
        LinkedList<Integer> secondHalfOfDivisors = new LinkedList<Integer>();
        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0) {
                firstHalfOfDivisors.add(i);
                secondHalfOfDivisors.addFirst(n/i);
            }
        }

        return join(toArrayInt(firstHalfOfDivisors), toArrayInt(secondHalfOfDivisors));
    }

    public static int[] integerStringToDigits(String num) {
        int[] digits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            digits[i] = charToInt(num.charAt(i));
        }
        return digits;
    }

    public static String digitsToIntegerString(int[] num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            builder.append(num[i]);
        }
        return builder.toString();
    }

    public static boolean isLegalDigits(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < 0 || digits[i] > 9) {
                return false;
            }
        }
        return true;
    }

    public static int[] fixDigits(int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] < 0) {
                throw new IllegalArgumentException("Digits array cannot have negative digits!");
            }
        }

        int[] digits = clone(in);
        for (int i = digits.length-1; i >= 1; i--) {
            if (digits[i] >= 10) {
                digits[i-1] += digits[i]/10;
                digits[i] = digits[i]%10;
            }
        }
        if (digits[0] >= 10) {
            int[] temp = clone(digits);
            digits = new int[temp.length+1];
            for (int i = 0; i < temp.length; i++) {
                digits[i+1] = temp[i];
            }
            digits[0] = digits[1]/10;
            digits[1] = digits[1]%10;
        }
        return digits;
    }

    public static String sumIntegerStrings(String num1, String num2) {
        // make sure the numbers don't start with zeroes
        num1 = stripZeroesFromStart(num1);
        num2 = stripZeroesFromStart(num2);

        // make sure num1 has the same or bigger amount of digits
        if (num2.length() > num1.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }

        int[] num1Digits = integerStringToDigits(num1);
        int[] num2Digits = integerStringToDigits(num2);

        for (int i = 0; i < num2Digits.length; i++) {
            num1Digits[num1Digits.length - num2Digits.length + i] += num2Digits[i];
        }
        if (!isLegalDigits(num1Digits)) {
            num1Digits = fixDigits(num1Digits);
        }
        return digitsToIntegerString(num1Digits);
    }

    public static String stripZeroesFromStart(String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                index++;
            }
            else {
                break;
            }
        }
        return str.substring(index);
    }

    public static boolean isPalindrome(String str) {
        String firstHalf = str.substring(0, str.length()/2);
        String secondHalf = str.substring((str.length()+1)/2);

        return firstHalf.equals(reverse(secondHalf));
    }

    public static int sumOfIntegersUpTo(int n) {
        return (n*(n+1))/2;
    }

    public static int getCollatzLength(int nIn) {
        if (nIn <= 0) {
            throw new IllegalArgumentException("number cannot be less than 1!");
        }
        long n = nIn;
        int amount = 1;
        while (n != 1) {
            amount++;
            if (n%2 == 0) {
                n = n/2;
            }
            else {
                n = (3*n)+1;
            }
        }
        return amount;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }

        return result;
    }

    public static BigInteger choose(int a, int b) {
        BigInteger top = factorial(a);
        BigInteger bottom = factorial(b).multiply(factorial(a-b));

        return top.divide(bottom);
    }
}
