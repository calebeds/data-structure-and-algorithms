package calebeoliveira.me.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int j = 0, k = 0;

        if(array1.length == 0) {
            mergedArray = array2;
        } else if(array2.length == 0) {
            mergedArray = array1;
        } else {
            for (int i = 0; i < mergedArray.length; i++) {
                if(j!= array1.length && (k == array2.length || array1[j] < array2[k])) {
                    mergedArray[i] = array1[j];
                    j++;
                } else {
                    mergedArray[i] = array2[k];
                    k++;
                }
            }
        }


        return mergedArray;
    }

    public static void main(String[] args) {
        int[] intArray = mergeSortedArrays(new int[]{1, 4, 4, 5, 10}, new int[]{5, 11, 13, 45, 86, 99, 100});


        Arrays.stream(intArray).forEach(System.out::println);
    }
}
