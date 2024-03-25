package calebeoliveira.me.linkedlists.singly;

import java.util.Map;

public class SinglyLinkedList {
    private SinglyLinkedNode head;
    private SinglyLinkedNode tail;
    private int length;

    public SinglyLinkedList(int value) {
        head = new SinglyLinkedNode(value);
        tail = head;
        length = 1;
    }

    public void prepend(int value) {
        this.head = new SinglyLinkedNode(value, head);
//        SinglyLinkedNode newNode = new SinglyLinkedNode(value);
//        newNode.setNext(this.head);
//        this.head = newNode;
        this.length++;
    }

    public void append(int value) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(value);
        this.tail.setNext(newNode);
        tail = newNode;
        length++;
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

        SinglyLinkedNode leader = traverseToIndex(index - 1);
        SinglyLinkedNode nextNode = leader.getNext();

        SinglyLinkedNode newNode = new SinglyLinkedNode(value, nextNode);
        leader.setNext(newNode);
        this.length++;

        //Old implementation
        //        SinglyLinkedNode previousNode = this.head;
//        SinglyLinkedNode currentNode = this.head;
//        for (int i = 0; i < length; i++) {
//
//            if(i != 0 && i == index - 1) {
//                previousNode = currentNode;
//            }
//
//            if(i == index) {
//                SinglyLinkedNode newNode = new SinglyLinkedNode(value);
//                newNode.setNext(currentNode);
//                previousNode.setNext(newNode);
//                length++;
//                break;
//            }
//
//            currentNode = this.head.getNext();
//        }
    }

    private SinglyLinkedNode traverseToIndex(int index) {
        index = this.wrapIndex(index);
        SinglyLinkedNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    /**
     * Used for wrapping the given index to make sure it's valid
     * @param index
     * @return
     */
    private int wrapIndex(int index) {
        return Math.min(index, length - 1);
    }

    public void printList() {
        if(this.head == null) {
            return;
        }

        SinglyLinkedNode currentNode = this.head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(5);
        singlyLinkedList.printList();

        singlyLinkedList.append(16);
        singlyLinkedList.printList();


        singlyLinkedList.prepend(1);
        singlyLinkedList.printList();

        singlyLinkedList.insert(1, 7);


        singlyLinkedList.printList();
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
