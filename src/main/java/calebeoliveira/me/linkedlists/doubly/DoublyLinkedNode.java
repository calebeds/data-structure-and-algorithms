package calebeoliveira.me.linkedlists.doubly;

public class DoublyLinkedNode {
    private int value;
    private DoublyLinkedNode previous;
    private DoublyLinkedNode next;

    public DoublyLinkedNode(int value) {
        this.previous = null;
        this.value = value;
        this.next = null;
    }

    public DoublyLinkedNode(int value, DoublyLinkedNode previous, DoublyLinkedNode next) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoublyLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedNode previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }
}
