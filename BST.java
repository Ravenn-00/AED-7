public class BST <T extends Comparable<T>> {
    private Nodo<T> raiz;

    public BST() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    private void insertarRecursivo(Nodo<T> actual, Nodo<T> nuevo) {
        if (nuevo.getDato().compareTo(actual.getDato()) < 0) {
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(nuevo);
            } else {
                insertarRecursivo(actual.getIzquierda(), nuevo);
            }
        } else {
            if (actual.getDerecha() == null) {
                actual.setDerecha(nuevo);
            } else {
                insertarRecursivo(actual.getDerecha(), nuevo);
            }
        }
    }

    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " ");
            inOrdenRecursivo(nodo.getDerecha());
        }
    }

    public void preOrden() {
        preOrdenRecursivo(raiz);
    }

    private void preOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrdenRecursivo(nodo.getIzquierda());
            preOrdenRecursivo(nodo.getDerecha());
        }
    }

    public void postOrden() {
        postOrdenRecursivo(raiz);
    }

    private void postOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.getIzquierda());
            postOrdenRecursivo(nodo.getDerecha());
            System.out.print(nodo.getDato() + " ");
        }
    }
    
}
