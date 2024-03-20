package calebeoliveira.me.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {

    private int length;
    private int capacity;
    private Object[] data;

    public Array() {
        this.capacity = 1;
        this.length = 0;
        this.data = new Object[1];
    }

    public Object get(int index) {
        return this.data[index];
    }

    public void push(Object item) {
        if(capacity == length) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
        this.data[this.length] = item;
        this.length++;
    }

    public Object pop() {
        Object lastItem = this.data[this.length - 1];
        data[length - 1] = null;
        length--;
        return lastItem;
    }

    public Object delete(int index) {
        Object item = this.data[index];
        this.shiftItems(index);
        return item;
    }

    private void shiftItems(int index) {
        for(int i = index; i < this.length - 1; i++) {
            this.data[i] = this.data[i+1];
        }
        data[this.length - 1] = null;
        this.length--;
    }

    public static void main(String[] args) {
        Array array = new Array();
        array.push(1);
        array.push("you");
        array.push("vvv");
        array.delete(2);
        array.push("are");
        array.delete(0);
        array.push("nice");

        System.out.println(array);
    }

    @Override
    public String toString() {
        return "Array{" +
                "length=" + length +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
