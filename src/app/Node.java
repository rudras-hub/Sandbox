package app;

public class Node {
    private int value;

    private Node leftChild;

    private Node rightChild;

    public Node(int value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int GetValue() {
        return this.value;
    }

    public Node GetLeftChild() {
        return this.leftChild;
    }

    public Node GetRightChild() {
        return this.rightChild;
    }

}