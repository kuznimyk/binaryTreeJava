public class BSTree {
    BNode root;

    public BSTree(){
        root = null;
    }

    public BNode getRoot(){
        return root;
    }
    public void insert(int id, String name){
        BNode insert  = new BNode(name, id);
        insertIntoTree(root, insert);
    }

    private void insertIntoTree(BNode root, BNode insert){
        BNode node = root;
        if (insert.getID() > node.getID() && node.getRightChild() != null){
            insertIntoTree(node.getRightChild(), insert);
        }
        else if (insert.getID() < node.getID() && node.getLeftChild() != null){
            insertIntoTree(node.getLeftChild(), insert);
        }
        else if (insert.getID() == node.getID()){
            System.out.println("The node of this ID is already in the tree");
        }
        else{
            if (insert.getID() > node.getID()){
                node.setRightChild(insert);
            }
            else {
                node.setLeftChild(insert);
            }
        }

    }

    public String preOrderString(){
        return " ";
    }
}
