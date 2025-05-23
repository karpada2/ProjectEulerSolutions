public final class P033 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P033().run());
    }

    public String run() {
        int[][] pairs = new int[4][2];
        int pairsIndex = 0;
        for (int numerator = 11; numerator < 99; numerator++) {
            for (int denominator = numerator+1; denominator < 100; denominator++) {
                if (!(numerator%10 == 0 || denominator%10 == 0)) {
                    if ((double)(numerator)/(double)(denominator) == (double)(numerator/10)/(double)(denominator/10) && numerator%10 == denominator%10) {
                        pairs[pairsIndex][0] = numerator;
                        pairs[pairsIndex][1] = denominator;
                        pairsIndex++;
                    }
                    else if ((double)(numerator)/(double)(denominator) == (double)(numerator%10)/(double)(denominator/10) && numerator/10 == denominator%10) {
                        pairs[pairsIndex][0] = numerator;
                        pairs[pairsIndex][1] = denominator;
                        pairsIndex++;
                    }
                    else if ((double)(numerator)/(double)(denominator) == (double)(numerator/10)/(double)(denominator%10) && numerator%10 == denominator/10) {
                        pairs[pairsIndex][0] = numerator;
                        pairs[pairsIndex][1] = denominator;
                        pairsIndex++;
                    }
                    else if ((double)(numerator)/(double)(denominator) == (double)(numerator%10)/(double)(denominator%10) && numerator/10 == denominator/10) {
                        pairs[pairsIndex][0] = numerator;
                        pairs[pairsIndex][1] = denominator;
                        pairsIndex++;
                    }
                }
            }
        }

        // since pairs[n][0] is always smaller than pairs[n][1], we know product[0] < product[1]
        int[] product = {
                pairs[0][0]*pairs[1][0]*pairs[2][0]*pairs[3][0],
                pairs[0][1]*pairs[1][1]*pairs[2][1]*pairs[3][1],
        };

        int divideBy = 1;
        int[] combinedFactors = UtilLibrary.intersection(UtilLibrary.getPrimeFactors(product[0]), UtilLibrary.getPrimeFactors(product[1]));

        for (int i = 0; i < combinedFactors.length; i++) {
            divideBy *= combinedFactors[i];
        }

        return Integer.toString(product[1]/divideBy);
    }
}
