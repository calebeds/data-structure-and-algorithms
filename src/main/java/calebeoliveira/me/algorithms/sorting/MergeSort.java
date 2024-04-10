package calebeoliveira.me.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
    public static Integer[] mergeSort(Integer[] array) {
        return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Integer[0]);
    }
    public static List<Integer> mergeSort(List<Integer> array) {
        if(array.size() == 1) {
            return array;
        }
        //Split Array in into right and left
        List<Integer> left = array.subList(0, array.size() / 2);
        System.out.println("Splitting left: " + left);
        List<Integer> right = array.subList(array.size() / 2, array.size());
        System.out.println("Splitting right: " + right);


        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) { //keep merging until we're done with one of sides
            if(left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));//merging all "leftovers" elements as is because we know they are sorted
        merged.addAll(right.subList(rightIndex, right.size())); //same
        System.out.println("Merged: " + merged);
        return merged;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
        Arrays.stream(mergeSort(array)).forEach(System.out::println);
    }
}
