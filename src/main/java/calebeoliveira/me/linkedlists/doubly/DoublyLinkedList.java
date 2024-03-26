package calebeoliveira.me.linkedlists.doubly;

import calebeoliveira.me.linkedlists.singly.SinglyLinkedList;

public class DoublyLinkedList {
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int length;

    public DoublyLinkedList(int value) {
        this.head = new DoublyLinkedNode(value);
        this.tail = this.head;
        this.length++;
    }

    public void prepend(int value) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(value, null, this.head);
        this.head.setPrevious(newNode);
        this.head = newNode;
        this.length++;
    }

    public void append(int value) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(value, this.tail, null);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    public void insert(int index, int value) {
        index = this.wrapIndex(index);
        if(index == 0) {
            this.prepend(value);
            return;
        }

        if(index == length - 1) {
            this.append(value);
            return;
        }

        DoublyLinkedNode leader = traverseToIndex(index - 1);
        DoublyLinkedNode follower = leader.getNext();

        DoublyLinkedNode newNode = new DoublyLinkedNode(value, leader, follower);
        leader.setNext(newNode);
        follower.setPrevious(newNode);
        this.length++;
    }

    public void remove(int index) {
        index = wrapIndex(index);

        if(index == 0) {
            this.head = this.head.getNext();
            this.head.setPrevious(null);;
            this.length--;
            return;
        }

        DoublyLinkedNode leader = traverseToIndex(index - 1);
        DoublyLinkedNode nodeToRemove = leader.getNext();
        DoublyLinkedNode follower = nodeToRemove.getNext();

        leader.setNext(follower);
        follower.setPrevious(leader);
        this.length--;
    }

    private DoublyLinkedNode traverseToIndex(int index) {
        index = wrapIndex(index);
        DoublyLinkedNode currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    private int wrapIndex(int index) {
        return Math.max(Math.min(index, length - 1), 0);
    }

    public void printList() {
        if(this.head == null) {
            return;
        }

        DoublyLinkedNode currentNode = this.head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(5);
        doublyLinkedList.prepend(6);
        doublyLinkedList.append(9);
        doublyLinkedList.append(8);
        doublyLinkedList.insert(2, 99);
        doublyLinkedList.printList();
        doublyLinkedList.remove(2);
        doublyLinkedList.printList();
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
