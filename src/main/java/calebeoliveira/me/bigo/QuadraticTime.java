package calebeoliveira.me.bigo;

public class QuadraticTime {

    public static void main(String[] args) {
        String[] boxes = {"a", "b", "c", "d", "e"};
//        logAllPairsOfArray(boxes);
        printAllNumbersThenAllPairSums(new int[]{1, 2, 3, 4});
    }

    public static void compressBoxesTwice(String[] boxes, String[] boxes2) {
        for (String box : boxes) {
            System.out.println(box);
        }
        for (String box : boxes2) {
            System.out.println(box);
        }
    }   // O(a + b)
    //if it were nested, it would be O(a*b)

    public static void logAllPairsOfArray(String[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                System.out.println(array[i] + "" + array[j]);
            }
        }
    } // O(n^2) - Quadratic Time


    public static void printAllNumbersThenAllPairSums(int[] numbers) {
        System.out.println("These are the numbers: ");
        for (int number : numbers) {
            System.out.println(number);
        }

        System.out.println("And these are their sums: ");
        for (int number : numbers) {
            for (int number2 : numbers) {
                System.out.println(number + number2);
            }
        }
    } //O(n + n^2) => O(n^2)
}
