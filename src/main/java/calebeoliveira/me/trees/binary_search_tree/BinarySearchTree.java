package calebeoliveira.me.trees.binary_search_tree;

public class BinarySearchTree {
    private BstNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        BstNode newNode = new BstNode(value);

        if(root == null) {
            this.root = newNode;
            return;
        }

        BstNode currentNode = this.root;

        while (true) {
            if(value < currentNode.getValue()) {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    return;
                }
                currentNode = currentNode.getLeft();
            } else {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }



    public boolean lookup(int value) {
        BstNode currentNode = this.root;
        while (currentNode != null) {
            if(value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else if (value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
            } else {
                return true;
            }
        }
        return false;
    }

    int count;
    public void printTree() {
        count = 0;
        printTree(root);
    }

    public void printTree(BstNode node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if(node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if(node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(9);

        binarySearchTree.insert(4);

        binarySearchTree.insert(6);

        binarySearchTree.insert(20);

        binarySearchTree.insert(170);

        binarySearchTree.insert(15);

        binarySearchTree.insert(1);

        binarySearchTree.printTree();

        System.out.println(binarySearchTree.lookup(20));
        System.out.println(binarySearchTree.lookup(11));
    }
}
