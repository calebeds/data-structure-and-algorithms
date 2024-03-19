package calebeoliveira.me.bigo;

public class Boo {

    public static void main(String[] args) {
        boooo(new int[]{1, 2, 3, 4, 5}); //space complexity O(1)
        arrayOfHiNTimes(6); // space complexity O(n)
    }
    public static void boooo(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println("Boooooooo");
        }
    }

    public static String[] arrayOfHiNTimes(int n) {
        String[] hiArray = new String[n];

        for (int i = 0; i < n; i++) {
            hiArray[i] = "hi";
            System.out.print(hiArray[i] + ", ");
        }

        return hiArray;
    }


}
