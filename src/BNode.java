public class BNode {
    int id;
    String name;
    BNode rightChild;
    BNode leftChild;

    public BNode(String name, int id){
        this.id = id;
        this.name =name;
        rightChild = null;
        leftChild = null;
    }
    public void setRightChild(BNode insert){
        BNode node = insert;
        this.rightChild = node;

    }
    public void setLeftChild(BNode insert){
        BNode node = insert;
        this.leftChild = node;
    }

    public BNode getLeftChild() {
        return leftChild;
    }

    public BNode getRightChild() {
        return rightChild;
    }
    public int getID(){
        return id;
    }
    public String toString(){
        return name + id;
    }
}
