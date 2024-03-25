package calebeoliveira.me.linkedlists.singly;

public class SinglyLinkedNode {
    private int value;
    private SinglyLinkedNode next;

    public SinglyLinkedNode(int value) {
        this.value = value;
        this.next = null;
    }

    public SinglyLinkedNode(int value, SinglyLinkedNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyLinkedNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SinglyLinkedNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
