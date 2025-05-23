public final class P028 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P028().run());
    }

    static int sprialSize = 1001;

    public String run() {
        int sum = 1;
        int currNumber = 1;
        for (int added = 2; added < sprialSize; added+=2) {
            for (int i = 0; i < 4; i++) {
                currNumber += added;
                sum += currNumber;
            }
        }

        return Integer.toString(sum);
    }
}
