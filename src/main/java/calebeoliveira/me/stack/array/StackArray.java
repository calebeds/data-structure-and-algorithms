package calebeoliveira.me.stack.array;

import java.util.ArrayList;
import java.util.List;

public class StackArray {

    private List<String> array = new ArrayList<>();

    public StackArray() {
    }

    public String peek() {
        return array.get(array.size() - 1);
    }

    public void push(String value) {
        array.add(value);
    }

    public String pop() {
        return array.remove(array.size() - 1);
    }

    public void printStack() {
        System.out.println("Printing stack");
        for (String element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push("Google");
        stack.printStack();
        stack.push("Udemy");
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}
