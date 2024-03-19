package calebeoliveira.me.bigo;

import java.util.HashMap;

public class ContainsCommonItem {
    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'x'};
        char[] array2 = {'z', 'y', 'a'};

        System.out.println(containsCommonItem(array1, array2));
    }

    private static boolean containsCommonItem(char[] array1, char[] array2) {
//        for (char el1: array1) {
//            for (char el2: array2) {
//                if(el1 == el2) {
//                    System.out.println("Found commmon element");
//                    return true;
//                }
//            }
//        }// O(a*b)
//
        // loop through first array and create object where properties
        // === items in the array
        HashMap<Character, Boolean> hashMap = new HashMap<>();

        for (char c: array1) {
            hashMap.put(c, true);
        }

        // loop though second array and check if item in second array exists on created object
        for (char arr: array2) {
            if(hashMap.containsKey(arr)) {
                return true;
            }
        }
        return false;
        //O(a + b)
    }
}
