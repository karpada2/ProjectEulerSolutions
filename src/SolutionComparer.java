public class SolutionComparer {
    Solution solution;
    String actualSolution;

    public SolutionComparer(Solution solution, String actualSolution) {
        this.solution = solution;
        this.actualSolution = actualSolution;
    }

    public boolean isCorrect() {
        return solution.run().equals(actualSolution);
    }

    public String getSolution() {
        return solution.run();
    }
}
