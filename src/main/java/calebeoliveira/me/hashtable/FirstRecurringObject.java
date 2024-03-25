package calebeoliveira.me.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class FirstRecurringObject {
    public static Object getFirstRecurringObject(Object[] inputArray) {

        int diff = inputArray.length;
        int index = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if(inputArray[i].equals(inputArray[j]) && (j - i) < diff) {
                    diff = j - i;
                    index = i;
                }
            }
            if(i == inputArray.length - 1 && diff != inputArray.length) {
                return inputArray[index];
            }
        }

        return null;
    } //O(n^2)

    public static Object getFirstRecurringObjectBetter(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>();
        for(Object obj: inputArray) {
            if (map.contains(obj)){
                return obj;
            } else {
                map.add(obj);
            }
        }
        return null;
    }//O(n)

    //Bad solution
    public static Object getFirstRecurringObjectHashTableButNotGood(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>(Arrays.asList(inputArray));
        for (Object object: inputArray) {
            if(map.contains(object)) {
                return object;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("First recurring character: " + getFirstRecurringObject(new Integer[]{2, 5, 1, 2, 3, 5}));
        System.out.println("First recurring character: " + getFirstRecurringObject(new Integer[]{2, 1, 1, 2, 3, 5}));
        System.out.println("First recurring character: " + getFirstRecurringObject(new Integer[]{2, 4, 3, 5}));

        System.out.println("First recurring character better: " + getFirstRecurringObjectBetter(new Integer[]{2, 5, 1, 2, 3, 5}));
        System.out.println("First recurring character better: " + getFirstRecurringObjectBetter(new Integer[]{2, 1, 1, 2, 3, 5}));
        System.out.println("First recurring character better: " + getFirstRecurringObjectBetter(new Integer[]{2, 4, 3, 5}));


        System.out.println("First recurring character not so good: " + getFirstRecurringObjectHashTableButNotGood(new Integer[]{2, 5, 1, 2, 3, 5}));
        System.out.println("First recurring character not so good: " + getFirstRecurringObjectHashTableButNotGood(new Integer[]{2, 1, 1, 2, 3, 5}));
        System.out.println("First recurring character not so good: " + getFirstRecurringObjectHashTableButNotGood(new Integer[]{2, 4, 3, 5}));
    }
}
