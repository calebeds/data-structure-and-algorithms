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
        BstNode holdingPointer = this.root;
        while (holdingPointer != null) {
            if(value > holdingPointer.getValue()) {
                holdingPointer = holdingPointer.getRight();
            } else if (value < holdingPointer.getValue()){
                holdingPointer = holdingPointer.getLeft();
            }

            if(holdingPointer != null && holdingPointer.getValue() == value) {
                return true;
            }
        }
        return false;
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
        System.out.println(binarySearchTree);

        binarySearchTree.insert(4);
        System.out.println(binarySearchTree);

        binarySearchTree.insert(20);
        System.out.println(binarySearchTree);

        binarySearchTree.insert(1);
        System.out.println(binarySearchTree);

        System.out.println(binarySearchTree.lookup(20));
        System.out.println(binarySearchTree.lookup(11));
    }
}
