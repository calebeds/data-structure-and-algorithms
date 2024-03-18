package calebeoliveira.me.bigo;

import java.util.Arrays;

public class Nemo {

    public static void main(String[] args) {
        String[] nemo = {"nemo"};
        String[] everyone = {"dory", "bruce", "marlin", "nemo", "gill", "bloat", "nigel", "squirt", "darla", "hank"};
        String[] large = Arrays.stream(new String[100000]).map(l -> "nemo").toArray(String[]::new);

        findNemo(large);
    }

    public static void findNemo(String[] array) {
        var t0 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            if("nemo".equals(array[i])) {
                System.out.println("Found NEMO!");
            }
        }
        var t1 = System.currentTimeMillis();
        System.out.println("Call to find Nemo took " + (t1 - t0) + " milliseconds");
    }
}
