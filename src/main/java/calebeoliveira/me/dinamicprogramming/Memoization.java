package calebeoliveira.me.dinamicprogramming;

import java.util.HashMap;

public class Memoization {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int addTo80(int n) {
        System.out.println("long time");
        return 80 + n;
    }

    public int addTo80Memoized(int n) {
        if(cache.containsKey(n)) {
            return cache.get(n);
        } else {
            System.out.println("long time");
            cache.put(n, 80 + n);
            return cache.get(n);
        }
    }

    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        System.out.println("Without cache");
        System.out.println(memoization.addTo80(5));
        System.out.println(memoization.addTo80(5));
        System.out.println(memoization.addTo80(5));
        System.out.println(memoization.addTo80(5));

        System.out.println("With cache");
        System.out.println(memoization.addTo80Memoized(5));
        System.out.println(memoization.addTo80Memoized(5));
        System.out.println(memoization.addTo80Memoized(5));
        System.out.println(memoization.addTo80Memoized(5));
    }
}
