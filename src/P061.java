import java.util.Arrays;

public final class P061 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P061().run());
    }

    public static boolean isPolygonal(int s, int n) {
        double result = (Math.sqrt((8*n*(s-2)) + Math.pow(s-4, 2)) + (s-4))/(2L *(s-2));
        return Math.abs(result - (long)(result)) <= 0.001;
    }

    @Override
    public String run() {
        for (int a = 1111; a <= 9999; a++) {
            int[] checks = {3, 4, 5, 6, 7, 8};
            boolean isAValid = false;
            for (int i = checks.length-1; i >= 0 && !isAValid; i--) {
                if (isPolygonal(checks[i], a)) {
                    checks[i] = -1;
                    isAValid = true;
                }
            }
            if (isAValid) {
                for (int b = ((a%100)*100) + 10; b <= ((a%100)*100) + 99; b++) {
                    int[] bChecks = Arrays.copyOf(checks, checks.length);
                    boolean isBValid = false;
                    for (int i = bChecks.length-1; i >= 0 && !isBValid; i--) {
                        if (bChecks[i] != -1 && isPolygonal(bChecks[i], b)) {
                            bChecks[i] = -1;
                            isBValid = true;
                        }
                    }
                    if (isBValid && UtilLibrary.countDigits(b) == 4) {
                        for (int c = ((b%100)*100) + 10; c <= ((b%100)*100) + 99; c++) {
                            int[] cChecks = Arrays.copyOf(bChecks, bChecks.length);
                            boolean isCValid = false;
                            for (int i = cChecks.length-1; i >= 0 && !isCValid; i--) {
                                if (cChecks[i] != -1 && isPolygonal(cChecks[i], c)) {
                                    cChecks[i] = -1;
                                    isCValid = true;
                                }
                            }
                            if (isCValid && UtilLibrary.countDigits(c) == 4) {
                                for (int d = ((c%100)*100) + 10; d <= ((c%100)*100) + 99; d++) {
                                    int[] dChecks = Arrays.copyOf(cChecks, cChecks.length);
                                    boolean isDValid = false;
                                    for (int i = dChecks.length-1; i >= 0 && !isDValid; i--) {
                                        if (dChecks[i] != -1 && isPolygonal(dChecks[i], d)) {
                                            dChecks[i] = -1;
                                            isDValid = true;
                                        }
                                    }
                                    if (isDValid && UtilLibrary.countDigits(d) == 4) {
                                        for (int e = ((d%100)*100) + 10; e <= ((d%100)*100) + 99; e++) {
                                            int[] eChecks = Arrays.copyOf(dChecks, dChecks.length);
                                            boolean isEValid = false;
                                            for (int i = eChecks.length-1; i >= 0 && !isEValid; i--) {
                                                if (eChecks[i] != -1 && isPolygonal(eChecks[i], e)) {
                                                    eChecks[i] = -1;
                                                    isEValid = true;
                                                }
                                            }
                                            if (isEValid && UtilLibrary.countDigits(e) == 4) {
                                                int f = ((e%100)*100) + (a/100);
                                                boolean isFValid = false;
                                                for (int i = eChecks.length-1; i >= 0 && !isFValid; i--) {
                                                    if (eChecks[i] != -1 && isPolygonal(eChecks[i], f)) {
                                                        eChecks[i] = -1;
                                                        isFValid = true;
                                                    }
                                                }
                                                boolean allvalid = true;
                                                for (int i = 0; i < eChecks.length; i++) {
                                                    if (eChecks[i] != -1) {
                                                        allvalid = false;
                                                    }
                                                }
                                                if (allvalid && UtilLibrary.countDigits(f) == 4) {
                                                    return Integer.toString(a + b + c + d + e + f);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "-1";
    }
}
