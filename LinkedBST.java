public class LinkedBST <T extends Comparable<T>> {
    class Node{
        public T data;
        public Node left;
        public Node right;
        public Node() {
            this.data = null;
            this.left = null;
            this.right = null;
        }
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
    private Node current;
    public LinkedBST() {
        this.root = null;
        this.current = null;
    }
    public LinkedBST(Node root) {
        this.root = root;
        this.current = root;
    }
    public void insert(T data) throws ItemDuplicated {
        Node nuevo = new Node(data);
        if(insertRe(current, nuevo) == null) {
            throw new ItemDuplicated("item duplicado");
        };
    }
    private Node insertRe(Node current, Node nuevo) {
        if(nuevo.data.compareTo(current.data) == 0) {
            return null;
        }
        else if(nuevo.data.compareTo(current.data) < 0) {
            if(current.left == null){
                current.left = nuevo;
            }else{
                return insertRe(current.left, nuevo);
            }
        }
        else {
            if(current.right == null){
                current.right = nuevo;
            }else{
                return insertRe(current.right, nuevo);
            }
        }
        return null;
    }
    public void delete(T data) throws ExceptionIsEmpty {
        
    }
    public T search(T data) throws ItemNotFound {
        return null;        
    }
    @Override
    public String toString() {
        String s = "";
        return s;        
    }
    public void destroyNodes() {

    }
    public void countAllNodes() {

    }
    public void countNodes() {

    }
    public void height() {

    }
    public void amplitude() {

    }
    public void areaBTS() {

    }
    public void drawBST() {

    }
    public void sameArea() {

    }
    public void parenthesize() {

    }
}
