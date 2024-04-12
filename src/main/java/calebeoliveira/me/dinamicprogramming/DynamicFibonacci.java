package calebeoliveira.me.dinamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DynamicFibonacci {

    int calculations = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    public static int fibonnaci(int n) {
        if(map.containsKey(n)) {
            return map.get(n);
        }

        if(n < 2) {
            return n;
        }

        map.put(n ,fibonnaci(n - 1) + fibonnaci(n - 2));
        return map.get(n);
    }



    public static void main(String[] args) {
        System.out.println(fibonnaci(1000));
    }
}
