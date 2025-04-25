public final class P009 implements Solution {
    public static void main(String[] args) {
        System.out.println(new P009().run());
    }

    public String run() {
        for (int a = 1; a < 1000-2; a++) {
            for (int b = a; b < 1000-2-a; b++) {
                int c = 1000-a-b;
                if ((a*a) + (b*b) == (c*c)) {
                    System.out.println("a: " + a + "\nb: " + b + "\nc: " + c);
                    return Integer.toString(a*b*c);
                }
            }
        }
        return "";
    }
}
