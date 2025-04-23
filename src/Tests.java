public class Tests {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\033[0;92m";

    static String[][] solutions = new String[][]{
            {new P001().run(), "233168"},
            {new P002().run(), "4613732"},
            {new P003().run(), "6857"}
    };

    public static String getNameOfProblemFromIndex(int index) {
        StringBuilder builder = new StringBuilder("P");
        index++;
        if (index < 100) {
            builder.append(0);
        }
        if (index < 10) {
            builder.append(0);
        }
        builder.append(index);
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < solutions.length; i++) {
            boolean success = (solutions[i][0].equals(solutions[i][1]));
            System.out.println(getNameOfProblemFromIndex(i) + " " + (success ? ANSI_GREEN + "success" : ANSI_RED + "failed") + ANSI_RESET);
        }
    }
}
