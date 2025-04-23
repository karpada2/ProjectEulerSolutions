import java.util.LinkedList;

public class UtilLibrary {

    public static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int end = arr.length-1, start = 0; end >= 0; end--, start++) {
            newArr[start] = arr[end];
        }
        return newArr;
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
            int tempCurr = curr;
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
}
