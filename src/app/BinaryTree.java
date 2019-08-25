package app;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BinaryTree {

    private ArrayList<Node> preOrderList = new ArrayList<Node>();

    private ArrayList<Node> inOrderList = new ArrayList<Node>();

    private ArrayList<Node> postOrderList = new ArrayList<Node>();

    /**
     * Adds a new node in a binary search tree.
     * 
     * @param rootNode Root of a tree or subtree
     * @param value    Value of node to be added
     * @return The new node added.
     */
    public Node addNode(Node rootNode, int value) {
        if (rootNode == null) {
            return new Node(value, null, null);
        }
        if (value <= rootNode.getValue()) {
            return addNode(rootNode.getLeftChild(), value);
        } else {
            return addNode(rootNode.getRightChild(), value);
        }
    }

    /**
     * Finds if a value exists in a binary search tree
     * 
     * @param rootNode The root of a tree/subtree
     * @param value    Value to find
     * @return Flag indicating if the value exists.
     */
    public Boolean findValue(Node rootNode, int value) {
        if (rootNode == null) {
            return false;
        }
        if (value == rootNode.getValue()) {
            return true;
        }
        if (value <= rootNode.getValue()) {
            return findValue(rootNode.getLeftChild(), value);
        } else {
            return findValue(rootNode.getRightChild(), value);
        }
    }

    /**
     * Finds minimum value of a binary search tree.
     * 
     * @param rootNode Root node of the tree
     * @return The minimum value of the tree.
     */
    public int findMin(Node rootNode) {
        if (rootNode == null) {
            return Integer.MIN_VALUE;
        }
        if (rootNode.getLeftChild() == null) {
            return rootNode.getValue();
        }
        return findMin(rootNode.getLeftChild());
    }

    /**
     * Finds maximum value of a binary search tree.
     * 
     * @param rootNode Root of the tree.
     * @return The maximum value of the tree.
     */
    public int findMax(Node rootNode) {
        if (rootNode == null) {
            return Integer.MAX_VALUE;
        }
        if (rootNode.getRightChild() == null) {
            return rootNode.getValue();
        }
        return findMax(rootNode);
    }

    /**
     * Gets the height of a binary tree.
     * 
     * @param rootNode Root of the tree.
     * @return Height of the tree.
     */
    public int getHeight(Node rootNode) {
        if (rootNode == null) {
            return -1;
        }
        return Math.max(getHeight(rootNode.getLeftChild()), getHeight(rootNode.getRightChild())) + 1;

    }

    /**
     * Gets nodes of a binary tree in level order
     * 
     * @param rootNode Root node of the tree.
     * @return List of nodes in sorted level order.
     */
    public ArrayList<Node> getElementsInLevelOrder(Node rootNode) {
        ArrayList<Node> sortedElements = new ArrayList<Node>();
        ArrayDeque<Node> levelOrderQueue = new ArrayDeque<Node>();

        levelOrderQueue.push(rootNode);

        while (!levelOrderQueue.isEmpty()) {
            Node currentNode = levelOrderQueue.pop();
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (leftChild != null) {
                levelOrderQueue.push(leftChild);
            }

            if (rightChild != null) {
                levelOrderQueue.push(rightChild);
            }

            sortedElements.add(currentNode);
        }

        return sortedElements;
    }

    /**
     * Gets nodes of a tree in pre-order Root->Left->Right
     * 
     * @param rootNode The root node of the tree.
     * @return List of tree nodes in pre-order.
     */
    public ArrayList<Node> getPreOrderList(Node rootNode) {
        getElementsInPreOrder(rootNode);
        return this.preOrderList;
    }

    /**
     * Gets nodes of a tree in-order Left->Root->Right
     * 
     * @param rootNode The root node of the tree.
     * @return List of tree nodes in-order.
     */
    public ArrayList<Node> getInOrderList(Node rootNode) {
        getElementsInOrder(rootNode);
        return this.inOrderList;
    }

    /**
     * Gets nodes of a tree in post-order Left->Right->Root
     * 
     * @param rootNode The root node of the tree.
     * @return List of nodes in post-order.
     */
    public ArrayList<Node> getPostOrderList(Node rootNode) {
        getElementsInPostOrder(rootNode);
        return postOrderList;
    }

    private void getElementsInPreOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        preOrderList.add(rootNode);
        getElementsInPreOrder(rootNode.getLeftChild());
        getElementsInPreOrder(rootNode.getRightChild());
    }

    private void getElementsInOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        getElementsInOrder(rootNode.getLeftChild());
        inOrderList.add(rootNode);
        getElementsInOrder(rootNode.getRightChild());
    }

    private void getElementsInPostOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        getElementsInPostOrder(rootNode.getLeftChild());
        getElementsInPostOrder(rootNode.getRightChild());
        postOrderList.add(rootNode);
    }

}