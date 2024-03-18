package calebeoliveira.me.bigo;

import java.util.Arrays;

public class LinearTime {

    public static void main(String[] args) {
        String[] nemo = {"nemo"};
        String[] everyone = {"dory", "bruce", "marlin", "gill", "bloat", "nigel", "squirt", "darla", "hank", "nemo"};
        String[] large = Arrays.stream(new String[100000]).map(l -> "nemo").toArray(String[]::new);

        findNemo(large);  // O(n) --> Linear Time
    }

    public static void findNemo(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("running");
            if ("nemo".equals(array[i])) {
                System.out.println("Found NEMO!");
                break;
            }
        }
    }


}
