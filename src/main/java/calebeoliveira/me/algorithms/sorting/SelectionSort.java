package calebeoliveira.me.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            // set current index as minimum
            int min = i;
            int temp = array[i];
            for (int j = i + 1; j < length; j++) {
                   if(array[j] < array[min]) {
                       min = j;
                   }
            }
            array[i] = array[min];
            array[min] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        Arrays.stream(selectionSort(new int[]{5, 9, 250, 4, 1, 0, 26})).forEach(System.out::println);
    }
}
