package app;

public class BinaryTree{

    public Node CreateNewBST(Node rootNode, int value){
        if(rootNode == null){
            return new Node(value, null, null);
        }
        if(value <= rootNode.GetValue()){
            return CreateNewBST(rootNode.GetLeftChild(), value);
        }
        else{
            return CreateNewBST(rootNode.GetRightChild(), value);
        }
    }

    
}