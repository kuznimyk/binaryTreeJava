public class BSTree {
    BNode root;

    public BSTree(){
        root = null;
    }

    public BNode getRoot(){
        return root;
    }
    public void insert(int id, String name){
        if (root == null){
            root = new BNode(name, id);
        }
        else {
            BNode insert = new BNode(name, id);
            insertIntoTree(root, insert);
        }
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
        return preOrder(root);
    }
    private String preOrder(BNode root){
        BNode node = root;
        if (node.getLeftChild() != null){
            return node.getName() + " " + preOrder(node.getLeftChild());
        }
        else if (node.getRightChild() != null){
            return node.getName() + " " + preOrder(node.getRightChild());
        }
        else{
            return node.getName();
        }
    }

    public String postOrderString(){
        return postOrder(root);
    }

    private String postOrder(BNode root){
        BNode node = root;
        if (node.getLeftChild() != null){
            return   preOrder(node.getLeftChild()) + " " + node.getName() ;
        }
        else if (node.getRightChild() != null){
            return  preOrder(node.getRightChild()) + " " +  node.getName();
        }
        else{
            return node.getName();
        }
    }

    public String inOrderString(){
        return inOrder(root);
    }

    private String inOrder(BNode root){
        BNode node = root;
        if (node.getLeftChild() != null){
            return   preOrder(node.getLeftChild()) + " " + node.getName() ;
        }
        else if (node.getRightChild() != null){
            return    node.getName() + " " + preOrder(node.getRightChild()) ;
        }
        else{
            return node.getName();
        }
    }

    public String toString(){
        return inOrderId(root);
    }
    private String inOrderId(BNode root){
        BNode node = root;
        if (node.getLeftChild() != null){
            return   preOrder(node.getLeftChild()) + " " + node.getID() ;
        }
        else if (node.getRightChild() != null){
            return    node.getID() + " " + preOrder(node.getRightChild()) ;
        }
        else{
            return node.getID() + "";
        }
    }

    public String findNameOf(int id){


        String name =  findId(root, id ) ;
        if (name == ""){
            return "NOT FOUND";
        }
        else{
            return name;
        }
    }

    private String findId(BNode root, int id){
        BNode node = root;
        if (node.getID() == id){
            return node.getName();
        }
        else{
            if (node.getRightChild() != null){
                return "" + findId(node.getRightChild(), id);
            }
            else if (node.getLeftChild() != null){
                return ""+ findId(node.getLeftChild(), id);
            }
            else{
                return "";
            }
        }
    }


    public int findIdNumOf(String name){
        return findName(root, name);
    }

    private int findName(BNode root, String name){
        BNode node = root;
        if (node.getName() == name){
            return node.getID();
        }
        else{
            if (node.getRightChild() != null){
                return 0 + findName(node.getRightChild(), name);
            }
            else if (node.getLeftChild() != null){
                return 0 + findName(node.getLeftChild(), name);
            }
            else{
                return 0;
            }
        }
    }

    public int numEntriesBetween(int x, int y){
        BNode nodeX = findNodeById(this.root, x);
        BNode nodeY = findNodeById(this.root, y);
        BNode ancestor = findLowestCommonAncestor(this.root, nodeX,nodeY);
        return distanceFromAncestor( nodeX,ancestor) + distanceFromAncestor( nodeY,ancestor);
    }

    private BNode findNodeById(BNode root, int id){
        BNode node = root;
        if (node.getID() == id){
            return node;
        }
        else{
            if (node.getRightChild() != null){
                return findNodeById(node.getRightChild(), id);
            }
            else if (node.getLeftChild() != null){
                return findNodeById(node.getLeftChild(), id);
            }
            else{
                return null;
            }
        }
    }

    private BNode findLowestCommonAncestor(BNode root, BNode nodeX, BNode nodeY) {
        if (root == null || nodeX == null || nodeY == null) {
            return null; // If any node is null, there's no common ancestor
        }

        if (nodeX.getID() > root.getID() && nodeY.getID() > root.getID()) {
            return findLowestCommonAncestor(root.getRightChild(), nodeX, nodeY);
        } else if (nodeX.getID() < root.getID() && nodeY.getID() < root.getID()) {
            return findLowestCommonAncestor(root.getLeftChild(), nodeX, nodeY);
        } else {
            return root; // Found the lowest common ancestor
        }
    }

    private int distanceFromAncestor(BNode node, BNode ancestor) {
        if (node == null || ancestor == null) {
            return 0;
        }

        if (node == ancestor) {
            return 0;
        }

        // Recursively find the distance from node to ancestor
        if (node.getID() < ancestor.getID()) {
            return 1 + distanceFromAncestor(node.getRightChild(), ancestor);
        } else {
            return 1 + distanceFromAncestor(node.getLeftChild(), ancestor);
        }
    }
}
