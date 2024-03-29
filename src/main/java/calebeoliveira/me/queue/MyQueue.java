package calebeoliveira.me.queue;

import java.util.Stack;

public class MyQueue {
    private Node first;
    private Node last;
    private int length;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Node peek() {
        return this.first;
    }

    public void enqueue(String value) {
        Node newNode = new Node(value);

        if(length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }

        length++;
    }

    public void dequeue() {
        if(this.first == null) {
            return;
        }

        if(this.length == 1) {
            this.last = null;
        }

        this.first = this.first.getNext();
        length--;
    }
    public void printQueue() {
        if(this.first == null) {
            return;
        }

        Node currentNode = first;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();

    }


    @Override
    public String toString() {
        return "MyQueue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        MyQueue newQueue = new MyQueue();
        newQueue.enqueue("Calebe");
        newQueue.printQueue();
        newQueue.enqueue("Matt");
        newQueue.printQueue();
        newQueue.enqueue("Damon");
        newQueue.printQueue();
        newQueue.enqueue("Sara");
        newQueue.printQueue();
        newQueue.dequeue();
        newQueue.printQueue();

        Stack<String> strings = new Stack<>();

    }
}
