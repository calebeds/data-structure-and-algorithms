package calebeoliveira.me.algorithms.recursion;

public class Fibonacci {
    public static int fibonacciIterative(int n) { //Time complexity of O(n)
        if(n == 0) {
            return 0;
        }

        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }

    public static int fibonacciRecursive(int n) { //Time complexity of O(2^n)
        if(n < 2) {
            return n;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciIterative(0));
        System.out.println(fibonacciRecursive(1));
    }

}
