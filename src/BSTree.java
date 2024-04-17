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
        return preOrder(root,  new String[]{""});
    }
    private String preOrder(BNode node, String[] res){
        if (node == null){
            return "";
        }
        res[0] += node.getName() + " ";
        preOrder(node.getLeftChild(), res);
        preOrder(node.getRightChild(), res);

        return res[0];
    }

    public String postOrderString(){
        return postOrder(root, new String[]{""}) ;
    }

    private String postOrder(BNode node, String[] res){
        if (node == null){
            return "";
        }
        postOrder(node.getLeftChild(), res);
        postOrder(node.getRightChild(), res);

        res[0] += node.getName() + " ";


        return res[0];
    }

    public String inOrderString(){
        return inOrder(root, new String[]{""});
    }

    private String inOrder(BNode node, String[] res){
        if (node == null) {
            return ""; // Return empty string if the root is null
        }
        inOrder(node.getLeftChild(), res);
        res[0] += node.getName() + " ";
        inOrder(node.getRightChild(), res);

        // Combine the results from left subtree, current node's ID, and right subtree
        return  res[0];
    }

    public String toString(){
        return inOrderId(root);
    }
    private String inOrderId(BNode root){
        if (root == null) {
            return ""; // Return empty string if the root is null
        }

        String leftString = inOrderId(root.getLeftChild());
        String rightString = inOrderId(root.getRightChild());

        // Combine the results from left subtree, current node's ID, and right subtree
        return leftString + " " + root.toString() + " " + rightString;
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

    private int findName(BNode node, String name){
        if (node == null){
            return 0;
        }
        if (node.getName() == name){
            return node.getID();
        }
        else{
            return findName(node.getLeftChild(), name) + findName(node.getRightChild(),name);
        }
    }

    public int numEntriesBetween(int x, int y){
        BNode nodeX = findNodeById(this.root, x);
        BNode nodeY = findNodeById(this.root, y);
        BNode ancestor = findLowestCommonAncestor(this.root, nodeX,nodeY);
        return distanceFromAncestor( nodeX,ancestor) + distanceFromAncestor( nodeY,ancestor);
    }

    private BNode findNodeById(BNode root, int id) {
        BNode node = root;
        if (node == null) {
            return null;
        }
        else if (node.getID() == id) {
            return node;
        }
        else {
            BNode resleft, resright;

            resright = findNodeById(node.getRightChild(), id);
            resleft = findNodeById(node.getLeftChild(), id);
            if (resright != null || resleft != null){
                return resleft == null ? resright : resleft;
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
            return 1 + distanceFromAncestor(node, ancestor.getLeftChild());
        } else {
            return 1 + distanceFromAncestor(node, ancestor.getRightChild());
        }
    }
}
