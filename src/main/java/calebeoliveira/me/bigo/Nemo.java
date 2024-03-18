package calebeoliveira.me.bigo;

import java.util.Arrays;

public class Nemo {

    public static void main(String[] args) {
        String[] nemo = {"nemo"};
        String[] everyone = {"dory", "bruce", "marlin", "nemo", "gill", "bloat", "nigel", "squirt", "darla", "hank"};
        String[] large = Arrays.stream(new String[100000]).map(l -> "nemo").toArray(String[]::new);

        findNemo(large);  // O(n) --> Linear Time
    }

    public static void findNemo(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if ("nemo".equals(array[i])) {
                System.out.println("Found NEMO!");
            }
        }
    }
}
