package calebeoliveira.me.bigo;

public class Print {
    public static void main(String[] args) {

    }

    public static void printFirstItemThenFirstHalfThenSayHi100Times(int[] items) {
        System.out.println(items[0]);

        double middleIndex = Math.floor(items.length / 2);
        int index = 0;

        while (index < middleIndex) { // O(2/n)
            System.out.println(items[index]);
            index ++;
        }

        for(int i = 0; i < 100; i++) { // O(100)
            System.out.println("Hi");
        }

        // this function is O(n)
    }
}
