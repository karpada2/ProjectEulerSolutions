import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public final class P063 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P063().run());
    }

    public static boolean isAllFalse(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String run() {
        boolean[] numbersToCheck = new boolean[10];
        for (int i = 1; i < numbersToCheck.length; i++) {
            numbersToCheck[i] = true;
        }

        int counter = 0;
        for (int num = 1; !isAllFalse(numbersToCheck); num++) {
            for (int j = 0; j < numbersToCheck.length; j++) {
                if (numbersToCheck[j]) {
                    if (BigInteger.valueOf(j).pow(num).toString().length() == num) {
                        counter++;
                    }
                    else {
                        numbersToCheck[j] = false;
                    }
                }
            }
        }

        return Integer.toString(counter);
    }
}
