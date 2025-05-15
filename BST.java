public class BST <T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }
    public int getAltura() {
        return getAlturaRecursivo(root);
    }
    public int getAlturaRecursivo(Node<T> Node) {
        if (Node == null) {
            return 0;
        }
        int alturootquierda = getAlturaRecursivo(Node.getLeft());
        int alturaDerecha = getAlturaRecursivo(Node.getRight());
        return Math.max(alturootquierda, alturaDerecha) + 1;
    }

    public void insertar(T data) {
        Node<T> nuevo = new Node<>(data);
        if (root == null) {
            root = nuevo;
        } else {
            insertarRecursivo(root, nuevo);
        }
    }
    private void insertarRecursivo(Node<T> actual, Node<T> nuevo) {
        if (nuevo.getData().compareTo(actual.getData()) < 0) {
            if (actual.getLeft() == null) {
                actual.setLeft(nuevo);
            } else {
                insertarRecursivo(actual.getLeft(), nuevo);
            }
        } else {
            if (actual.getRight() == null) {
                actual.setRight(nuevo);
            } else {
                insertarRecursivo(actual.getRight(), nuevo);
            }
        }
    }
    public void inOrden() {
        inOrdenRecursivo(root);
    }

    private void inOrdenRecursivo(Node<T> Node) {
        if (Node != null) {
            inOrdenRecursivo(Node.getLeft());
            System.out.print(Node.getData() + " ");
            inOrdenRecursivo(Node.getRight());
        }
    }

    public void preOrden() {
        preOrdenRecursivo(root);
    }

    private void preOrdenRecursivo(Node<T> Node) {
        if (Node != null) {
            System.out.print(Node.getData() + " ");
            preOrdenRecursivo(Node.getLeft());
            preOrdenRecursivo(Node.getRight());
        }
    }

    public void postOrden() {
        postOrdenRecursivo(root);
    }

    private void postOrdenRecursivo(Node<T> Node) {
        if (Node != null) {
            postOrdenRecursivo(Node.getLeft());
            postOrdenRecursivo(Node.getRight());
            System.out.print(Node.getData() + " ");
        }
    }
    public T search(T x) throws ItemNotFound {
        Node<T> res = searchRec(x, this.root);
        if (res == null)
            throw new ItemNotFound ("El data "+ x + "no esta");
        return res.getData();
    }
    protected Node<T> searchRec(T x, Node<T> n){
        if (n == null) return null;
        else {
            int resC = n.getData().compareTo(x);
            if (resC < 0) return searchRec(x, n.getRight());
            else if (resC > 0) return searchRec(x, n.getLeft());
            else return n;
        }
    }
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido InOrden:");
        arbol.inOrden();
        System.out.println();

        System.out.println("Recorrido PreOrden:");
        arbol.preOrden();
        System.out.println();

        System.out.println("Recorrido PostOrden:");
        arbol.postOrden();
        System.out.println("Árbol visual:");
        
    }
    
}
