package calebeoliveira.me.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class FirstRecurringObject {
    public static Object getFirstRecurringObject(Object[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if(inputArray[i].equals(inputArray[j])) {
                    return inputArray[i];
                }
            }
        }

        return null;
    }

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
    }

    public static Object getFirstRecurringObjectBetter2(Object[] inputArray) {
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


        System.out.println("First recurring character better: " + getFirstRecurringObjectBetter2(new Integer[]{2, 5, 1, 2, 3, 5}));
        System.out.println("First recurring character better: " + getFirstRecurringObjectBetter2(new Integer[]{2, 1, 1, 2, 3, 5}));
        System.out.println("First recurring character better: " + getFirstRecurringObjectBetter2(new Integer[]{2, 4, 3, 5}));
    }
}
