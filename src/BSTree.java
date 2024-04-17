public class BSTree {
    BNode root;
    /*basic and parameter constructors*/
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
    /*if id is bigger than the current node's then go right
    * if smaller - go left until the last leaf reached*/
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

    /*prints out values of the tree in pre order*/
    private String preOrder(BNode node, String[] res){
        if (node == null){
            return "";
        }
        res[0] += node.getName() + " ";
        preOrder(node.getLeftChild(), res);
        preOrder(node.getRightChild(), res);

        return res[0];
    }
    /*prints out names of the tree in postorder*/

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

    /*prints out names of the tree in order of traversal*/
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
    /*toString method*/
    public String toString(){
        return inOrderString();
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

    /*method that finds the name by id
    * if the id is bigger than the current node's id then go right
    * if smaller than go left until it matches with the node's id*/
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

    /*method that finds the id by the name*/
    private int findName(BNode node, String name){
        if (node == null){
            return 0;
        }
        if (node.getName() == name){
            return node.getID();
        }
        else{
            /*traverses through the whole tree and if the name is not found
            * then return nothing and add up to final result, if found then return
            * the name which will be added up to string's final result*/
            return findName(node.getLeftChild(), name) + findName(node.getRightChild(),name);
        }
    }

    /*calculates the number of entries between two ids*/
    public int numEntriesBetween(int x, int y){
        BNode nodeX = findNodeById(this.root, x);
        BNode nodeY = findNodeById(this.root, y);
        BNode ancestor = findLowestCommonAncestor(this.root, nodeX,nodeY);
        return distanceFromAncestor( nodeX,ancestor) + distanceFromAncestor( nodeY,ancestor);
    }

    /*method that finds the node by id*/
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

        /*if both of ids are bigger than the root's, then go right, and check from there*/
        if (nodeX.getID() > root.getID() && nodeY.getID() > root.getID()) {
            return findLowestCommonAncestor(root.getRightChild(), nodeX, nodeY);
        } else if (nodeX.getID() < root.getID() && nodeY.getID() < root.getID()) {
            /*else if both ids are lower than the root's id then go left*/
            return findLowestCommonAncestor(root.getLeftChild(), nodeX, nodeY);
        } else {
            /*if one of the nodes is bigger than the root and the other one is smaller
            * than the common ancestor is found*/
            return root;
        }
    }
    /*finds the distance from the ancestor*/

    private int distanceFromAncestor(BNode node, BNode ancestor) {
        if (node == null || ancestor == null) {
            return 0;
        }

        if (node == ancestor) {
            return 0;
        }

        /*if id is bigger than the ancestor's then move ancestor to the right, if smaller
         then go left until the ancestor and
        * node have same id*/
        if (node.getID() < ancestor.getID()) {
            return 1 + distanceFromAncestor(node, ancestor.getLeftChild());
        } else {
            return 1 + distanceFromAncestor(node, ancestor.getRightChild());
        }
    }
}
