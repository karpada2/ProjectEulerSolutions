public final class P031 implements Solution {
    public static void main(String[] args) {
        double startNanoTime = System.nanoTime();
        System.out.println(new P031().run());
        System.out.println("time to end(sec): " + ((System.nanoTime()-startNanoTime)/1e+9));
    }

    int total = 200;
    public String run() {
        int amountOfWays = 0;
        for (int p1 = 0; p1 <= 200; p1++) {

            for (int p2 = 0; p2 <= 100; p2++) {
                if (p1 + p2*2 > 200) {
                    break;
                }

                for (int p5 = 0; p5 <= 40; p5++) {
                    if (p1 + p2*2 + p5*5 > 200) {
                        break;
                    }

                    for (int p10 = 0; p10 <= 20; p10++) {
                        if (p1 + p2*2 + p5*5 + p10*10 > 200) {
                            break;
                        }

                        for (int p20 = 0; p20 <= 10; p20++) {
                            if (p1 + p2*2 + p5*5 + p10*10 + p20*20 > 200) {
                                break;
                            }

                            for (int p50 = 0; p50 <= 4; p50++) {
                                if (p1 + p2*2 + p5*5 + p10*10 + p20*20 + p50*50 > 200) {
                                    break;
                                }

                                for (int p100 = 0; p100 <= 2; p100++) {
                                    if (p1 + p2*2 + p5*5 + p10*10 + p20*20 + p50*50 + p100*100 > 200) {
                                        break;
                                    }

                                    for (int p200 = 0; p200 <= 1; p200++) {
                                        if (p1 + p2*2 + p5*5 + p10*10 + p20*20 + p50*50 + p100*100 + p200*200 > 200) {
                                            break;
                                        }

                                        if (p1 + p2*2 + p5*5 + p10*10 + p20*20 + p50*50 + p100*100 + p200*200 == 200) {
                                            amountOfWays++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return Integer.toString(amountOfWays);
    }
}
