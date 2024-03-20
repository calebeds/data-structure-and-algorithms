package calebeoliveira.me;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

public class CommonItems {
    /* Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items
  For Example:
  const array1 = ['a', 'b', 'c', 'x'];
  const array2 = ['z', 'y', 'i'];
  should return false.
  -----------
  const array1 = ['a', 'b', 'c', 'x'];
  const array2 = ['z', 'y', 'x'];
  should return true.
  2 parameters - arrays - no size limit
  return true or false
  */
    private static Object[] array1 = {'a', "asd", '7', 'r', "null"};
    private static Object[] array2 = {'z', new String("asd"), null, 'x'};
    private static final boolean makeScalable = true; // For testing scale time duration

    public static void main(String[] args) {
        if(makeScalable) {
            array1 = new Object[100000];
            array2 = new Object[100000];
            Random s = new Random();
            for (int i = 0; i < array1.length; i++) {
                array1[i] = s.nextLong();
            }

            for (int i = 0; i < array2.length; i++) {
                array2[i] = s.nextLong();
            }
        }

        long startTime = System.nanoTime();
        boolean result = containsCommonItemsBetter(array1, array2);
        long endTime = System.nanoTime();
        System.out.format("Better solution result: %s with time of - %d%n", result, endTime - startTime);

        startTime = System.nanoTime();
        result = containsCommonItemsBetterAndCleaner(array1, array2);
        endTime = System.nanoTime();
        System.out.format("Better and cleaner solution result: %s with time of - %d%n", result, endTime - startTime);

        startTime = System.nanoTime();
        result = containsCommonItems(array1, array2);
        endTime = System.nanoTime();
        System.out.format("Bad solution result: %s with time of - %d%n", result, endTime - startTime);
    }



    /**
     * A "naive" approach for solving the question, with
     * time complexity of O(a * b) - exponential
     * space complexity of O(1) - constant.
     * Please note that we have to use {@link java.util.Objects#equals(Object, Object)} method so strings would work properly and
     * we are using the equal method in {@link java.util.Objects} class so we could accept null inputs without null exception
     * @param array1 - the first input array
     * @param array2 - the second input array
     * @return A boolean indicating whether those two array have any common items
     */
    private static boolean containsCommonItems(Object[] array1, Object[] array2) {
        for (Object obj1: array1) {
            for (Object obj2: array2) {
                if(Objects.equals(obj1, obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A better solution which includes the use of {@link java.util.HashSet}, here we are using {@link java.util.HashSet}
     * and NOT {@link java.util.HashMap} {key, value data structure} as it was demonstrated in the course as
     * there is no reason store true for each key we can check for common objects using the ${@link java.util.HashSet#contains(Object)} method.
     * time complexity of O(a + b) - linear
     * space complexity of O(c + d) - linear
     * @param array1 - the first input array
     * @param array2 - the second input array
     * @return A boolean indicating whether those two arrays have any common items
     */
    private static boolean containsCommonItemsBetter(Object[] array1, Object[] array2) {
        HashSet<Object> mapOfFirstArray = new HashSet<>();
        for (Object obj1: array1) {
            mapOfFirstArray.add(obj1);
        }

        for(Object obj2: array2) {
            if(mapOfFirstArray.contains(obj2))  {
                return true;
            }
        }

        return false;
    }

    /**
     * A better and cleaner solution which includes the use of {@link HashSet}, here we are using ${@link HashSet}
     * and NOT {@link java.util.HashMap} {key, value data structure} as it was demonstrated in the course as
     * there is no reason store true for each key we can check for common objects using the ${@link java.util.HashSet#contains(Object)} method.
     * This method also takes advantage of features added in Java SE8 {@link java.util.stream.Stream}
     * time complexity of O(a + b)
     * space complexity of O(c + d)
     * @param array1 - the first input array
     * @param array2 - the second input array
     * @return A boolean indicating whether those two arrays have any common items
     */
    private static boolean containsCommonItemsBetterAndCleaner(Object[] array1, Object[] array2) {
        HashSet<Object> mapOfFirstArray = new HashSet<>(Arrays.asList(array1));
        return Stream.of(array2).anyMatch(mapOfFirstArray::contains);
    }

}
