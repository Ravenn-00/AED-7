public interface BinarySearchTree<T> {
    void insert(T data) throws ItemDuplicated;
    T search(T x) throws ItemNotFound;
    void delete(T x) throws ExceptionIsEmpty;
    boolean isEmpty();
    
}
