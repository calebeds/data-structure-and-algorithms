package calebeoliveira.me.bigo;

public class Compress {

    public static void main(String[] args) {
        String[] boxes = {"a", "b", "c", "d", "e"};
        logAllPairsOfArray(boxes);

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


}
