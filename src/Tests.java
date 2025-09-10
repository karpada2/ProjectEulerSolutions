import java.util.Scanner;

public class Tests {
    static Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\033[0;92m";

    static SolutionComparer[] solutions = new SolutionComparer[]{
            new SolutionComparer(new P001(), "233168"),
            new SolutionComparer(new P002(), "4613732"),
            new SolutionComparer(new P003(), "6857"),
            new SolutionComparer(new P004(), "906609"),
            new SolutionComparer(new P005(), "232792560"),
            new SolutionComparer(new P006(), "25164150"),
            new SolutionComparer(new P007(), "104743"),
            new SolutionComparer(new P008(), "23514624000"),
            new SolutionComparer(new P009(), "31875000"),
            new SolutionComparer(new P010(), "142913828922"),
            new SolutionComparer(new P011(), "70600674"),
            new SolutionComparer(new P012(), "76576500"),
            new SolutionComparer(new P013(), "5537376230"),
            new SolutionComparer(new P014(), "837799"),
            new SolutionComparer(new P015(), "137846528820"),
            new SolutionComparer(new P016(), "1366"),
            new SolutionComparer(new P017(), "21124"),
            new SolutionComparer(new P018(), "1074"),
            new SolutionComparer(new P019(), "171"),
            new SolutionComparer(new P020(), "648"),
            new SolutionComparer(new P021(), "31626"),
            new SolutionComparer(new P022(), "871198282"),
            new SolutionComparer(new P023(), "4179871"),
            new SolutionComparer(new P024(), "2783915460"),
            new SolutionComparer(new P025(), "4782"),
            new SolutionComparer(new P026(), "983"),
            new SolutionComparer(new P027(), "-59231"),
            new SolutionComparer(new P028(), "669171001"),
            new SolutionComparer(new P029(), "9183"),
            new SolutionComparer(new P030(),  "443839"),
            new SolutionComparer(new P031(), "73682"),
            new SolutionComparer(new P032(), "45228"),
            new SolutionComparer(new P033(), "100"),
            new SolutionComparer(new P034(), "40730"),
            new SolutionComparer(new P035(), "55"),
            new SolutionComparer(new P036(), "872187"),
            new SolutionComparer(new P037(), "748317"),
            new SolutionComparer(new P038(), "932718654"),
            new SolutionComparer(new P039(), "840"),
            new SolutionComparer(new P040(), "210"),
            new SolutionComparer(new P041(), "7652413"),
            new SolutionComparer(new P042(), "162"),
            new SolutionComparer(new P043(), "16695334890"),
            new SolutionComparer(new P044(), "5482660"),
            new SolutionComparer(new P045(), "1533776805"),
            new SolutionComparer(new P046(), "5777"),
            new SolutionComparer(new P047(), "134043")
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
        System.out.println("enter index of answer to check (less than 1 will check all): ");
        int givenAnswer = sc.nextInt() - 1;

        if (givenAnswer >= 0 && givenAnswer < solutions.length) {
            System.out.println(getNameOfProblemFromIndex(givenAnswer) + " " + (solutions[givenAnswer].isCorrect() ? ANSI_GREEN + "success" : ANSI_RED + "failed") + ANSI_RESET);
        }
        else {
            for (int i = 0; i < solutions.length; i++) {
                System.out.println(getNameOfProblemFromIndex(i) + " " + (solutions[i].isCorrect() ? ANSI_GREEN + "success" : ANSI_RED + "failed") + ANSI_RESET);
            }
        }
    }
}
