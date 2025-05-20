public class Node <T> {
    public T data;
    public Node<T> left;
    public Node<T> right;
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
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public T getData() {
        return data;
    }
    public void setData(T x) {
        this.data = x;
    }
    public Node<T> getRight() {
        return this.right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public Node<T> getLeft() {
        return this.left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
}