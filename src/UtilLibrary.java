import java.math.BigInteger;
import java.util.*;
import java.util.function.IntUnaryOperator;

public class UtilLibrary {

    public static int maxIndex(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static int charToInt(char c) {
        return c-48;
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

    public static BigInteger fibonacci(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        if (n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        if (n.equals(BigInteger.valueOf(3))) {
            return BigInteger.TWO;
        }
        BigInteger oneBeforeLast = BigInteger.ZERO; // fibonacci(i-2)
        BigInteger last = BigInteger.ONE; // fibonacci(i-1)
        BigInteger curr = oneBeforeLast.add(last); // fibonacci(i)

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n.subtract(BigInteger.ONE)) < 0; i=i.add(BigInteger.ONE)) {
            last = curr;
            curr = oneBeforeLast.add(last);
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

        for (int i = 2; i < (int)(Math.sqrt(n)) + 1; i++) {
            if (n%i == 0 && isPrime(i)) {
                long num = n;
                while (num%i == 0) {
                    num /= i;
                    factorsSmallerThanSqrt.add((long)(i));
                }
            }
        }

        long mult = 1;

        for (int i = 0; i < factorsSmallerThanSqrt.size(); i++) {
            mult *= factorsSmallerThanSqrt.get(i);
        }

        if (mult != n) {
            factorsSmallerThanSqrt.add(n/mult);
        }

        return toArrayLong(factorsSmallerThanSqrt);
    }

    public static int[] getPrimeFactors(int n) {
        if (isPrime(n)) {
            return new int[]{1, n};
        }
        LinkedList<Integer> factorsSmallerThanSqrt = new LinkedList<Integer>();

        for (int i = 2; i < (int)(Math.sqrt(n)) + 1; i++) {
            if (n%i == 0 && isPrime(i)) {
                int num = n;
                while (num%i == 0) {
                    num /= i;
                    factorsSmallerThanSqrt.add(i);
                }
            }
        }

        int mult = 1;

        for (int i = 0; i < factorsSmallerThanSqrt.size(); i++) {
            mult *= factorsSmallerThanSqrt.get(i);
        }

        if (mult != n) {
            factorsSmallerThanSqrt.add(n/mult);
        }

        return toArrayInt(factorsSmallerThanSqrt);
    }

    public static int[] getDivisors(int n) {
        LinkedList<Integer> firstHalfOfDivisors = new LinkedList<Integer>();
        LinkedList<Integer> secondHalfOfDivisors = new LinkedList<Integer>();
        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0) {
                firstHalfOfDivisors.add(i);
                if (i != 1 && i != n/i) {
                    secondHalfOfDivisors.addFirst(n / i);
                }
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

    public static BigInteger factorialBigInteger(int n) {
        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }

        return result;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger choose(int a, int b) {
        BigInteger top = factorialBigInteger(a);
        BigInteger bottom = factorialBigInteger(b).multiply(factorialBigInteger(a-b));

        return top.divide(bottom);
    }

    public static int[][] cloneDeep(int[][] arr) {
        int[][] out = new int[arr.length][1];

        for (int i = 0; i < arr.length; i++) {
            out[i] = clone(arr[i]);
        }

        return out;
    }

    // 1600, 564, 23, 1000
    public static boolean isLeapYear(int year) {
        if (year%4 == 0) {
            if (year%100 == 0) {
                if (year%400 == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public static int sumDigits(BigInteger n) {
        int sum = 0;
        String number = n.toString();
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }
        return sum;
    }

    public static<T> boolean has(List<T> list, T value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static<T> boolean has(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    // is sum of divisors bigger than number
    public static boolean isAbundant(int n) {
        int[] divisors = getDivisors(n);
        int sum = 0;
        for (int i = 0; i < divisors.length; i++) {
            sum += divisors[i];
        }
        return sum > n;
    }

    public static int getSumOfDivisors(int n) {
        int[] divisors = getDivisors(n);
        int sum = 0;
        for (int i = 0; i < divisors.length; i++) {
            sum += divisors[i];
        }
        return sum;
    }

    // returns false if there is no next permutation in the lexicographical order, true otherwise. advances the array values to the next
    // permutation
    // should work by going backwards in the array, checking if there is any bigger value in a bigger index in the array. if so swap
    // them. if we went through the whole array and there is none, then there is no next permutation

    /*
    13245
    13254
    13425
    13452
    13524
    13542
     */
    //13254 -> 13425
    public static boolean nextPermutation(int[] arr) {
        if (arr.length <= 1) {
            return false;
        }
        for (int i = arr.length-2; i >= 0; i--) {
            int j = arr.length-1;
            for (; j > i; j--) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    int[] reversed = new int[arr.length - i - 1];
                    int reverseIndex = 0;
                    int forwardIndex = arr.length-1;
                    for (; forwardIndex > i; forwardIndex--, reverseIndex++) {
                        reversed[reverseIndex] = arr[forwardIndex];
                    }

                    int index = 0;
                    for (int k = i+1; k < arr.length; k++, index++) {
                        arr[k] = reversed[index];
                    }

                    return true;
                }
            }
        }
        return false;
    }

    public static int[] getPrimesUpTo(int n) {
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        // we have n numbers, 0 and 1 are immediately removed thus n-2, and +1 because we include n itself
        int amountOfTrue = n-2+1;

        for (int startingNumber = 2; startingNumber*startingNumber < n; startingNumber++) {
            if (isPrime[startingNumber]) {
                for (int currentNumber = startingNumber*startingNumber; currentNumber < isPrime.length; currentNumber+=startingNumber) {
                    if (isPrime[currentNumber]) {
                        amountOfTrue--;
                    isPrime[currentNumber] = false;
                    }
                }
            }
        }

        int[] primes = new int[amountOfTrue];
        int primesIndex = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes[primesIndex] = i;
                primesIndex++;
            }
        }

        return primes;
    }

    public static<T> int count(T[] arr, T value) {
        int amount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                amount++;
            }
        }
        return amount;
    }

    public static<T> T[] filter(T[] arr, T value) {
        T[] filtered = Arrays.copyOf(arr, arr.length-count(arr, value));

        int filteredIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(value)) {
                filtered[filteredIndex] = arr[i];
                filteredIndex++;
            }
        }

        return filtered;
    }

    public static<T> T[] removeFirstAppearance(T[] arr, T value) {
        if (has(arr, value)) {
            T[] removed = Arrays.copyOf(arr, arr.length-1);
            int removedIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(value)) {
                    for (int j = i+1; j < arr.length; j++) {
                        removed[removedIndex] = arr[j];
                        removedIndex++;
                    }
                    return removed;
                }
                else {
                    removed[removedIndex] = arr[i];
                    removedIndex++;
                }
            }
        }
        return Arrays.copyOf(arr, arr.length);
    }

    public static<T> T[] intersection(T[] arr1In, T[] arr2In) {
        T[] out;
        int outIndex = 0;
        if (arr1In.length >= arr2In.length) {
            T[] arr2InTemp = Arrays.copyOf(arr2In, arr2In.length);
            out = Arrays.copyOf(arr2In, arr2In.length);
            Arrays.fill(out, null);

            for (int i = 0; i < arr1In.length; i++) {
                if (has(arr2InTemp, arr1In[i])) {
                    arr2InTemp = removeFirstAppearance(arr2InTemp, arr1In[i]);
                    out[outIndex] = arr1In[i];
                    outIndex++;
                }
            }
        }
        else {
            T[] arr1InTemp = Arrays.copyOf(arr1In, arr1In.length);
            out = Arrays.copyOf(arr1In, arr1In.length);
            Arrays.fill(out, null);

            for (int i = 0; i < arr2In.length; i++) {
                if (has(arr1InTemp, arr2In[i])) {
                    arr1InTemp = removeFirstAppearance(arr1InTemp, arr2In[i]);
                    out[outIndex] = arr2In[i];
                    outIndex++;
                }
            }
        }

        out = Arrays.copyOf(out, outIndex);
        return out;
    }

    public static int[] intersection(int[] arr1In, int[] arr2In) {
        Integer[] arr1 = new Integer[arr1In.length];
        Integer[] arr2 = new Integer[arr2In.length];

        for (int i = 0; i < arr1In.length; i++) {
            arr1[i] = arr1In[i];
        }

        for (int i = 0; i < arr2In.length; i++) {
            arr2[i] = arr2In[i];
        }

        Integer[] result = intersection(arr1, arr2);

        int[] out = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            out[i] = result[i];
        }
        return out;
    }

    public static int[] breakIntoDigits(int num) {
        int[] digits = new int[(int)(Math.floor(Math.log10(num)+1))];
        for (int i = 0; i < digits.length; i++) {
            digits[digits.length - i - 1] = num%10;
            num = num/10;
        }
        return digits;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] applyToAll(int[] arr, IntUnaryOperator operator) {
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = operator.applyAsInt(arr[i]);
        }
        return out;
    }

    public static int[] circulateArray(int[] arr, int steps) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int newIndex = (((i+steps)%arr.length)+arr.length)%arr.length;
            result[newIndex] = arr[i];
        }
        return result;
    }


    public static int circulateNumber(int num, int steps) {
        return circulateNumber(num, steps, (int)Math.floor(Math.log10(num) + 1));
    }

    private static int circulateNumber(int num, int steps, int digitsInNumber) {
        if (steps == 0) {
            return num;
        }
        if (steps < 0) {
            return circulateNumber( ((num%(int)(Math.pow(10, digitsInNumber-1)))*10) + (num/(int)(Math.pow(10, digitsInNumber-1))), ++steps, digitsInNumber);
        }
        return circulateNumber((num/10) + ((num%10)*(int)(Math.pow(10, digitsInNumber-1))), --steps, digitsInNumber);
    }

    public static HashSet<Integer> arrToHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set;
    }

    public static boolean isPanDigital(int num) {
        int[] digits = UtilLibrary.breakIntoDigits(num);
        boolean[] appears = new boolean[digits.length];

        if (digits[UtilLibrary.maxIndex(digits)] - 1 >= appears.length) {
            return false;
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                return false;
            }
            appears[digits[i]-1] = true;
        }

        for (int i = 0; i < appears.length; i++) {
            if (!appears[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutationOf(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        boolean[] arr2TouchedPlaces = new boolean[arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && !arr2TouchedPlaces[j]) {
                    arr2TouchedPlaces[j] = true;
                }
            }
        }

        for (int i = 0; i < arr2TouchedPlaces.length; i++) {
            if (!arr2TouchedPlaces[i]) {
                return false;
            }
        }

        return true;
    }
}
