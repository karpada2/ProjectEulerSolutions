import java.util.Arrays;

public final class P005 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P005().bruteForce());
        System.out.println(new P005().elegant());
        System.out.println(new P005().run());
    }

    public String run() {
        return Integer.toString(elegant());
    }

    public int bruteForce() {
//        double startTimeNS = System.nanoTime();
        for (int n = 20; ; n++) {
            boolean failed = false;
            for (int i = 1; i < 21; i++) {
                if (n % i != 0) {
                    failed = true;
                    break;
                }
            }
            if (!failed) {
//                System.out.println("brute force NanoSecond to finish: " + (System.nanoTime() - startTimeNS));
                return n;
            }
        }
    }

    // this is like 6250 times faster lol
    public int elegant() {
//        double startTimeNS = System.nanoTime();
        int[][] divisors = new int[22][21]; //array of counter arrays of the divisors of each number
        for (int n = 2; n < divisors.length; n++) {
            int[] nDivisors = UtilLibrary.getPrimeFactors(n);
            for (int i = 0; i < nDivisors.length; i++) {
                divisors[n][nDivisors[i]]++;
            }
        }

        int[] counter = new int[divisors[0].length];
        for (int i = 0; i < divisors.length; i++) {
            for (int j = 0; j < divisors[i].length; j++) {
                if (divisors[i][j] > counter[j]) {
                    counter[j] = divisors[i][j];
                }
            }
        }
        int num = 1;
        for (int i = 1; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                num *= i;
            }
        }

//        System.out.println("elegant NanoSecond to finish: " + (System.nanoTime() - startTimeNS));
        return num;
    }
}
