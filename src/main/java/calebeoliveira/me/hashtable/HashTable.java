package calebeoliveira.me.hashtable;

public class HashTable {
    Object[][] data;
    public HashTable(int size) {
        this.data = new Object[size][2];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % this.data.length;
        }

        return hash;
    }

    public void set(String key, Object value) {
        int address = hash(key);

        if(data[address] != null) {
            data[address][0] = key;
            data[address][1] = value;
        }

    }

    public Object get(String key) {
        int address = hash(key);
        return data[address][1];
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        hashTable.set("grapes", 10000);
        System.out.println(hashTable.get("grapes"));
        hashTable.set("calebe", "dope");
        System.out.println(hashTable.get("calebe"));
    }
}
