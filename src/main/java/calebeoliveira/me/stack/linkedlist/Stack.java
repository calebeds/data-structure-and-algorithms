package calebeoliveira.me.stack.linkedlist;

public class Stack {
    private Node top;
    private Node bottom;
    private int length;
    public Stack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public Node peek() {
        return this.top;
    }

    public void push(String value) {
        Node newNode = new Node(value);

        if(length == 0) {
            this.top = newNode;
            this.bottom = newNode;

        } else {
            Node holdingPointer = this.top;
            this.top = newNode;
            this.top.setNext(holdingPointer);
        }

        length++;
    }

    public Node pop() {
        if(this.top == null) {
            return null;
        }

        Node oldTop = this.top;

        if(length == 1) {
            this.top = null;
            this.bottom = null;
        } else {
            this.top = this.top.getNext();
        }

        length--;
        return oldTop;
    }

    public void printStack() {
        if(this.top == null) {
            return;
        }

        Node currentNode = top;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();

    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void main(String[] args) {
        Stack newStack = new Stack();
        newStack.printStack();

        newStack.push("google");
        newStack.printStack();

        newStack.push("yotube");
        newStack.printStack();

        newStack.push("udemy");
        newStack.printStack();

        System.out.println(newStack.peek());

        System.out.println(newStack.pop());

        newStack.printStack();

        System.out.println(newStack.pop());

        newStack.printStack();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", length=" + length +
                '}';
    }
}
