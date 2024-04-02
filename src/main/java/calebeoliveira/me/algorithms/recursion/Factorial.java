package calebeoliveira.me.algorithms.recursion;

public class Factorial {
    public static int findFactorialRecursive(int x) {
        if(x == 1) {
            return x;
        }
        return x * findFactorialRecursive(x-1);
    }

    public static int findFactorialIterative(int x) {
        int answer = x;
        for(int i = x - 1; i > 1; i--) {
            answer = answer * i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialRecursive(4));
        System.out.println(findFactorialIterative(3));
    }
}
