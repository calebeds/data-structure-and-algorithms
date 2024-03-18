package calebeoliveira.me.bigo;

public class ConstantTime {
    public static void main(String[] args) {
        int[] boxes = {0, 1, 2, 3, 4, 5};
        printFirstTwoBoxes(boxes); // O(2) - Constante Time
    }
    
    public static void printFirstTwoBoxes(int[] boxes) {
        System.out.println(boxes[0]); // O(1)
        System.out.println(boxes[1]); // O(1)
    }

}
