package calebeoliveira.me.trees.binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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



    public BstNode lookup(int value) {
        BstNode currentNode = this.root;
        while (currentNode != null) {
            if(value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else if (value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
            } else {
                return currentNode;
            }
        }
        return null;
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

    public void remove(int value) {
        if(this.root == null) {
            return;
        }
        BstNode nodeToRemove = this.root;
        BstNode parentNode = null;

        while (nodeToRemove.getValue() != value) { //searching for the node to remove and its parent
            parentNode = nodeToRemove;
            if(value < nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        BstNode replacementNode = null;
        if(nodeToRemove.getRight() != null) { //We have a right node
            replacementNode = nodeToRemove.getRight();
            if(replacementNode.getLeft() == null) {//We don't have a left node
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else { //we have a left node, let's find the leftmost
                BstNode replacementParentNode = nodeToRemove;
                while (replacementNode.getLeft() != null) {
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }
                replacementParentNode.setLeft(null);
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }
        } else if (nodeToRemove.getLeft() != null) { //we have a left node
            replacementNode = nodeToRemove.getLeft();
        }

        if(parentNode == null) {
            root = replacementNode;
        } else if (parentNode.getLeft() == nodeToRemove) { //We are left child
            parentNode.setLeft(replacementNode);
        } else { //We are right child
            parentNode.setRight(replacementNode);
        }
    }

    public List<Integer> breathFirstSearchIteratively() {
        BstNode currentNode  = root;
        List<Integer> list = new ArrayList<>();
        Queue<BstNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            list.add(currentNode.getValue());
            if(currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if(currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        return list;
    }

    public List<Integer> breathFirstSearchRecursively() {
        Queue<BstNode> queue = new LinkedList<>();
        queue.add(root);
        return breathFirstSearchRecursively(queue, new ArrayList<>());
    }

    private List<Integer> breathFirstSearchRecursively(Queue<BstNode> queue, List<Integer> list) {
        if(queue.isEmpty()) {
            return list;
        }

        BstNode currentNode = queue.poll();
        list.add(currentNode.getValue());
        if(currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }

        if(currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }
        return breathFirstSearchRecursively(queue, list);
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
        binarySearchTree.remove(4);
        binarySearchTree.printTree();

        System.out.println("Breath first search: " + binarySearchTree.breathFirstSearchIteratively());
        System.out.println("Breath first search recursively " + binarySearchTree.breathFirstSearchRecursively());
    }
}
