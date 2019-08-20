package app;

import java.util.ArrayDeque;

public class BinaryTree {

    private ArrayDeque<Integer> levelOrderQueue = new ArrayDeque<Integer>();

    /**
     * Adds a new node in a binary search tree.
     * 
     * @param rootNode Root of a tree or subtree
     * @param value    Value of node to be added
     * @return The new node added.
     */
    public Node AddNode(Node rootNode, int value) {
        if (rootNode == null) {
            return new Node(value, null, null);
        }
        if (value <= rootNode.GetValue()) {
            return AddNode(rootNode.GetLeftChild(), value);
        } else {
            return AddNode(rootNode.GetRightChild(), value);
        }
    }

    /**
     * Finds if a value exists in a binary search tree
     * 
     * @param rootNode The root of a tree/subtree
     * @param value    Value to find
     * @return Flag indicating if the value exists.
     */
    public Boolean FindValue(Node rootNode, int value) {
        if (rootNode == null) {
            return false;
        }
        if (value == rootNode.GetValue()) {
            return true;
        }
        if (value <= rootNode.GetValue()) {
            return FindValue(rootNode.GetLeftChild(), value);
        } else {
            return FindValue(rootNode.GetRightChild(), value);
        }
    }

    /**
     * Finds minimum value of a binary search tree.
     * 
     * @param rootNode Root node of the tree
     * @return The minimum value of the tree.
     */
    public int FindMin(Node rootNode) {
        if (rootNode == null) {
            return Integer.MIN_VALUE;
        }
        if (rootNode.GetLeftChild() == null) {
            return rootNode.GetValue();
        }
        return FindMin(rootNode.GetLeftChild());
    }

    /**
     * Finds maximum value of a binary search tree.
     * 
     * @param rootNode Root of the tree.
     * @return The maximum value of the tree.
     */
    public int FindMax(Node rootNode) {
        if (rootNode == null) {
            return Integer.MAX_VALUE;
        }
        if (rootNode.GetRightChild() == null) {
            return rootNode.GetValue();
        }
        return FindMax(rootNode);
    }

    /**
     * Gets the height of a binary tree.
     * 
     * @param rootNode Root of the tree.
     * @return Height of the tree.
     */
    public int GetHeight(Node rootNode) {
        if (rootNode == null) {
            return -1;
        }
        return Math.max(GetHeight(rootNode.GetLeftChild()), GetHeight(rootNode.GetRightChild())) + 1;

    }

    /**
     * @todo Complete this
     */
    private void AddElementsInLevelOrder(Node rootNode) {
        if(rootNode != null){
            this.levelOrderQueue.add(rootNode.GetValue());
        }
        AddElementsInLevelOrder(rootNode.GetLeftChild());
        AddElementsInLevelOrder(rootNode.GetRightChild());
    }

}