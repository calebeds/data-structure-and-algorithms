package calebeoliveira.me.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                    if(array[j] > array[j + 1] ) {
                        // swap numbers
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = bubbleSort(new int[]{6, 5, 3, 4, 2, 1});
        Arrays.stream(bubbleSort(array)).forEach(System.out::println);
    }
}
