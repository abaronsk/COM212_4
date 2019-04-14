public class BST {
    private BST root;
    private int size;

    /** @Returns the size of the tree. */
    public int size() {
        return size;
    }

    /** @Returns true if the tree is empty, false otherwise */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /** @Returns true if v is the root of the tree. */
    public boolean isRoot(BSTNode v) {
        return (v == root);
    }
    /*
    /** @Returns true if v does not have any children, false otherwise.
    public boolean isExternal(BSTNode v) {
        return (v.getLeft() == null && v.getRight() == null );
    }*/

    /**
     * Returns the number of children
     */



    /**
     * Searches for the key k in the sub-tree rooted at v.
     * @returns the node where k is found, or null if k is not found.
     * Pass in root for v to search the entire tree.
     */
    public BSTNode find(int k, BSTNode v){
        if (v == null) { return null; }
        else if (v.getKey() == k) { return v; }
        else {
            if (v.getKey() < k) {
                return find(k, v.getRight());
            }
            else {
                return find(k, v.getLeft());
            }
        }
    }

    /**
     * Inserts a new node with key k into the BST.
     */
    private void recInsert(int k, BSTNode v){
        BSTNode u = new BSTNode(v, k, null, null);
        if (k > v.getKey()){
            if (v.getRight() != null){
                recInsert(k, v.right);
            }
            else{
                v.setRight(u);
            }
        }
        else if (k < v.getKey()){
            if (v.getLeft() != null){
                recInsert(k, v);
            }
            else {
                v.setLeft(u);
            }
        }
    }

    public void insert(int k){
        if (root == null){
            root = new BSTNode(null, k, null, null);
        }
        else {
            recInsert(k, root);
            size++;
        }
    }


    /**
     * Removes and returns a node in the tree with key k.
     * @returns null if k is not found.
     */
    public void BSTNode delete(int k){
        BSTNode delete = find (k);
        if (delete == null) { return null; } //if there's no node with key k
        else { //if there's a node with key k
            //case 1: when node with key k has no children
            if (delete.numChildren() == 0 ) { delete == null; }
            //case 2: when node with key k has one child
            else if (delete.numChildren(delete) == 1 ) {
                if (delete == delete.getParent().getLeft()) { //if delete has a left child
                    delete.getPare
                }
                else { //if delete has a right child
                    delete = delete.getRight();
                }
            }
            //case 3: when key k has two child
            else {

            }
            size--;
            return delete;
        }
    }

    /**
     * Prints out the keys of the tree in a preorder traversal
     */
    public void preOrder(BSTNode v) {
        v.displayNode();
        if (v.getLeft() != null) { //visit every left child of v
            preOder(v.getLeft());
        }
        if (v.getRight() != null) { //then visit right child
            preOrder(v.getRight());
        }
    }

    /**
     * Prints out the keys of the tree in a inorder traversal
     */
    public void inOrder(BSTNode v) {
        if (v.getLeft() != null) { //visit every left child of v
            preOder(v.getLeft());
        }
        v.displayNode();
        if (v.getRight() != null) { //then visit right child
            preOrder(v.getRight());
        }
    }

    /**
     * Prints out the keys of the tree in a postorder traversal
     */
    public void postOrder(BSTNode v){
        if (v.getleft() != null) { //visit every left child of v
            preoder(v.getLeft()); }
        if (v.getright() != null) { //then visit right child
            preorder(v.getRight());}
        v.displayNode();
    }

} //end of BST class