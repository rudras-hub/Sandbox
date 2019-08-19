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

    public Boolean FindValue(Node rootNode, int value){
        if(rootNode == null){
            return false;
        }
        if(value == rootNode.GetValue()){
            return true;
        }
        if(value <= rootNode.GetValue()){
            return FindValue(rootNode.GetLeftChild(), value);
        }
        else{
            return FindValue(rootNode.GetRightChild(), value);
        }     
    }

}