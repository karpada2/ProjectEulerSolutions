import java.util.HashSet;
import java.util.Set;

public final class P039 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P039().run());
    }

    public String run() {
        int maxP = 4;
        for (int p = 4; p <= 1000; p++) {
            if (amountOfSolutions(p) > amountOfSolutions(maxP)) {
                maxP = p;
            }
        }
        return Integer.toString(maxP);
    }

    public static int amountOfSolutions(int p) {
        int amountOfSolutions = 0;
        for (int a = 1; a < p-2; a++) {
            for (int b = 1; b < p-1; b++) {
                if (b >= a) {
                    int c = p - a - b;
                    if ((a*a)+(b*b) == (c*c)) {
                        amountOfSolutions++;
                    }
                }
            }
        }
        return amountOfSolutions;
    }
}
