public class Tests {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\033[0;92m";

    static String[][] solutions = new String[][]{
            {new P001().run(), "233168"},
            {new P002().run(), "4613732"},
            {new P003().run(), "6857"},
            {new P004().run(), "906609"},
            {new P005().run(), "232792560"},
            {new P006().run(), "25164150"},
            {new P007().run(), "104743"},
            {new P008().run(), "23514624000"},
            {new P009().run(), "31875000"},
            {new P010().run(), "142913828922"},
            {new P011().run(), "70600674"},
            {new P012().run(), "76576500"},
            {new P013().run(), "5537376230"},
            {new P014().run(), "837799"},
            {new P015().run(), "137846528820"},
            {new P016().run(), "1366"},
            {new P017().run(), "21124"},
            {new P018().run(), "1074"},
            {new P019().run(), "171"},
            {new P020().run(), "648"},
            {new P021().run(), "31626"},
            {new P022().run(), "871198282"},
            {new P023().run(), "4179871"},
            {new P024().run(), "2783915460"}
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
