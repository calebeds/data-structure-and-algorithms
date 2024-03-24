package calebeoliveira.me.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable2 {
    private static class MyNodes extends ArrayList<MyNode> {}
    private final int length;
    private MyNodes[] data;

    public HashTable2(int size) {
        this.length = size;
        data = new MyNodes[length];
    }

    public void set(String key, int value) {
        if(data[hash(key)] == null) {
            data[hash(key)] = new MyNodes();
        }
        data[hash(key)].add(new MyNode(key, value));
    }

    public int get(String key) {
        if(data[hash(key)] == null) {
            return 0;
        }
        for (MyNode node: data[hash(key)]) {
            if(node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return 0;
    }

    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(data[i] != null) {
                for (int j = 0; j < data[i].size(); j++) {
                    keys.add(data[i].get(j).getKey());
                }
            }
        }
        return keys;
    }

    private int hash(String key) {
        int hash = 0;

        for(int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % length;
        }

        return hash;
    }

    public static void main(String[] args) {
        HashTable2 table = new HashTable2(50);
        table.set("ra", 1000);
        table.set("foo", 1000);
        table.set("bar", 1000);
        System.out.println(table.keys().size());
        System.out.println(table.get("ra"));
        System.out.println(table.get("foo"));
        System.out.println(table.get("bar"));
    }
}
