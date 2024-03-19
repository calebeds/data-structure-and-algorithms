package calebeoliveira.me.bigo;

import java.util.HashSet;

public class GoogleInterview {
    public static void main(String[] args) {
        System.out.println(hasPairWithSum2(new int[]{1, 1, 5, 4}, 8));
    }

    // [1, 2, 6, 9]
    // [1, 2, 4, 4]

    // pair whose sum is 8
    // input: array, output: boolean

    // naive solution
    public static boolean hasPairWithSum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if((array[i] + array[j]) == 8 && i != j)
                    return true;
            }
        }
        return false;
    }

    // storing in a hashmap the complements of the set
    public static boolean hasPairWithSum2(int[] array, int sum) {
        // hashset to store complements
        HashSet<Integer> complements = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if(complements.contains(array[i])) {
                return true;
            }
            complements.add(sum - array[i]);
        }
        return false;
    }


}
