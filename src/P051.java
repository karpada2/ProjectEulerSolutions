import java.util.Arrays;
import java.util.HashSet;

public final class P051 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P051().run());
    }

    public static int[][] getIndexesToReplace(int n) {
        int digitAmount = UtilLibrary.countDigits(n);

        int arrLength = 0;
        for (int i = 1; i < digitAmount-1; i++) {
            arrLength += UtilLibrary.chooseInt(digitAmount, i);
        }
        
        int[][] result = new int[arrLength][digitAmount-1];
        int index = 0;

        for (int i = 1; i < digitAmount-1; i++) {
            int[] temp = new int[i];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = j;
            }

            for (int j = 0; j < UtilLibrary.chooseInt(digitAmount, i); j++) {
                boolean areDigitsEqualFlag = true;
                int digit = -1;
                for (int k = 0; k < temp.length && areDigitsEqualFlag; k++) {
                    if (temp[k] >= UtilLibrary.countDigits(n)) {
                        areDigitsEqualFlag = false;
                    }
                    else {
                        if (digit == -1) {
                            digit = UtilLibrary.getNthDigit(n, temp[k]);
                        }
                        else if (UtilLibrary.getNthDigit(n, temp[k]) != digit) {
                            areDigitsEqualFlag = false;
                        }
                    }
                }

                if (areDigitsEqualFlag) {
                    int[] clone = new int[temp.length];
                    for (int k = 0; k < temp.length; k++) {
                        clone[k] = temp[k];
                    }
                    result[index] = clone;
                    index++;
                }

                temp[temp.length-1]++;
                if (temp[temp.length-1] >= digitAmount) {
                    for (int k = temp.length-1; k > 0; k--) {
                        if (temp[k] >= digitAmount) {
                            temp[k-1]++;
                            for (int l = k; l < temp.length; l++) {
                                temp[l] = temp[l-1] + 1;
                            }
                        }
                    }
                }
            }
        }

        int[][] newResult = new int[index][1];
        for (int i = 0; i < newResult.length; i++) {
            newResult[i] = result[i];
        }
        return newResult;
    }

    public static final int assumed_max_digits = 5;
    public static final int assumed_upper_bound = (int)Math.pow(10, assumed_max_digits+1);
    public static final boolean[] primality = UtilLibrary.listPrimality(assumed_upper_bound);
    public static final int[] primes = UtilLibrary.getPrimesUpTo(assumed_upper_bound);

    @Override
    public String run() {
        int startingIndex = -1;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] > (int)Math.pow(10, assumed_max_digits)) {
                startingIndex = i;
                break;
            }

        }

        HashSet<Integer> checked = new HashSet<>(1000);
        for (int i = startingIndex; i < primes.length; i++) {
            int[][] indexesToReplace = getIndexesToReplace(primes[i]);
            checked.add(primes[i]);
            for (int j = 0; j < indexesToReplace.length; j++) {
                int[] primeAsDigits = UtilLibrary.breakIntoDigits(primes[i]);
                int primesCounter = 0;
                int thisCycleLowest = -1;
                for (int digit = 0; digit < 10; digit++) {
                    if (!(indexesToReplace[j][0] == 0 && digit == 0)) {
                        for (int replaceIndex = 0; replaceIndex < indexesToReplace[j].length; replaceIndex++) {
                            primeAsDigits[indexesToReplace[j][replaceIndex]] = digit;
                        }
                        int currentNumber = UtilLibrary.digitsIntoNumber(primeAsDigits);
                        if (primality[currentNumber]) {
                            if (thisCycleLowest == -1) {
                                thisCycleLowest = currentNumber;
                            }
                            primesCounter += 1;
                        }
                    }
                }
                if (primesCounter == 8) {
                    return Integer.toString(thisCycleLowest);
                }
            }
        }

        return "-1";
    }
}
